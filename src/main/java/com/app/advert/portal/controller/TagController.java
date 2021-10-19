package com.app.advert.portal.controller;

import com.app.advert.portal.dto.CompanyListRequest;
import com.app.advert.portal.dto.ResourceTagRequestDto;
import com.app.advert.portal.dto.TagRequestDto;
import com.app.advert.portal.service.TagService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tags")
@RequiredArgsConstructor
@Slf4j
@Api(value = "Tag Controller", produces = MediaType.APPLICATION_JSON_VALUE, tags = {"Tag"})
public class TagController {

    private final TagService tagService;

    @Operation(tags = {"Tag"}, description = "Add tag")
    @PostMapping("/addTag")
    public ResponseEntity<?> addTag(@Validated @RequestBody TagRequestDto requestDto) {
        try {
            log.info("TagController: Save new advert");
            return tagService.saveTag(requestDto.getName());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @Operation(tags = {"Tag"}, description = "Add resource tag")
    @PostMapping("/addResourceTag")
    public ResponseEntity<?> addResourceTag(@Validated @RequestBody ResourceTagRequestDto requestDto) {
        try {
            log.info("TagController: Add resource tag");
            return tagService.saveResourceTag(requestDto);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @Operation(tags = {"Tag"}, description = "Return tags list")
    @GetMapping("/list")
    public ResponseEntity<?> getCompaniesList(
            @RequestParam(required = false) Integer offset,
            @RequestParam(required = false) Integer limit
    ) {
        try {
            log.info("TagController: Return tags list");
            return tagService.getTagsList(limit, offset);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e);
        }

    }
}
