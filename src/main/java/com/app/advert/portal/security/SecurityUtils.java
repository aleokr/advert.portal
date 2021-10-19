package com.app.advert.portal.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public final class SecurityUtils {

    private final JwtTokenProperties jwtTokenProperties;

    public String getSecretKey() {
        return jwtTokenProperties.getSecretKey();
    }

    public Long getExpirationTime() {
        return jwtTokenProperties.getExpirationTime();
    }

    public Long getRefreshExpirationTime() {
        return jwtTokenProperties.getRefreshExpirationTime();
    }

    public static Long getLoggedUserId() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();

        if (authentication != null && authentication.getPrincipal() != null && !authentication.getPrincipal().equals("anonymousUser")) {
            return ((UserPrincipal) authentication.getPrincipal()).getUserId();
        }
        return null;
    }

    public static Long getLoggedCompanyId() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();

        if (authentication != null && authentication.getPrincipal() != null && !authentication.getPrincipal().equals("anonymousUser")) {
            return ((UserPrincipal) authentication.getPrincipal()).getCompanyId();
        }
        return null;
    }

    public static boolean isUserCompanyAdmin() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();

        if (authentication != null && authentication.getPrincipal() != null && !authentication.getPrincipal().equals("anonymousUser")) {
            return ((UserPrincipal) authentication.getPrincipal()).getAuthorities().stream().anyMatch(e-> e.getAuthority().equals("COMPANY_ADMIN"));
        }
        return false;
    }

    public static boolean isCompanyUser() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();

        if (authentication != null && authentication.getPrincipal() != null && !authentication.getPrincipal().equals("anonymousUser")) {
            return ((UserPrincipal) authentication.getPrincipal()).getAuthorities().stream().anyMatch(e-> e.getAuthority().equals("COMPANY_ADMIN") || e.getAuthority().equals("COMPANY_USER"));
        }
        return false;
    }
}
