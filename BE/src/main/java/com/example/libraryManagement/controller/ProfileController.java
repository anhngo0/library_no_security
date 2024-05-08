package com.example.libraryManagement.controller;

import com.example.libraryManagement.model.dto.fullInfo.ProfileFullInfoDto;
import com.example.libraryManagement.model.dto.ProfileMinInfoDto;
import com.example.libraryManagement.model.dto.form.UpsertProfileForm;
import com.example.libraryManagement.query.params.GetProfileParams;
import com.example.libraryManagement.service.IProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/profile")
@RequiredArgsConstructor
public class ProfileController {
    private final IProfileService profileService;
    private final PagedResourcesAssembler<ProfileMinInfoDto> profileMinInfoDtoPagedResourcesAssembler;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ProfileFullInfoDto> createProfile(
            @RequestPart("form")UpsertProfileForm upsertProfileForm,
            @RequestPart(value = "file", required = false)MultipartFile file
    ) {
       return ResponseEntity.ok(profileService.createProfile(upsertProfileForm,file));
    }

    @GetMapping("/fullInfo/{id}")
    public ResponseEntity<ProfileFullInfoDto> getFullInfoProfileById(
            @PathVariable("id") Long id
    ){
        return ResponseEntity.ok(profileService.getFullInfoProfile(id));
    }

    @GetMapping("/minInfo")
    public ResponseEntity<PagedModel<EntityModel<ProfileMinInfoDto>>> getMinInfoProfile(
            GetProfileParams getProfileParams,
            Pageable pageable
    ){
        PagedModel<EntityModel<ProfileMinInfoDto>> pagedModel = profileMinInfoDtoPagedResourcesAssembler.toModel(
                profileService.getMinInfoProfile(getProfileParams, pageable)
        );
        return ResponseEntity.ok(pagedModel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProfile(
            @RequestBody UpsertProfileForm upsertProfileForm,
            @PathVariable("id") Long id
    ) {
        return ResponseEntity.ok(profileService.updateProfile(upsertProfileForm, id));
    }
    @DeleteMapping("/id")
    public ResponseEntity<?> deleteProfileById (@PathVariable("id") Long id){
        profileService.deleteProfile(id);
        return ResponseEntity.ok("delete success");
    }

    @DeleteMapping
    public ResponseEntity<?> deleteProfilesInIds(@RequestBody List<Long> ids){
        profileService.deleteProfilesInIds(ids);
        return ResponseEntity.ok("delete sucess");
    }
}
