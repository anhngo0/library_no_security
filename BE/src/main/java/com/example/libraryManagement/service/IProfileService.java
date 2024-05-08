package com.example.libraryManagement.service;

import com.example.libraryManagement.model.dto.fullInfo.ProfileFullInfoDto;
import com.example.libraryManagement.model.dto.ProfileMinInfoDto;
import com.example.libraryManagement.model.dto.form.UpsertProfileForm;
import com.example.libraryManagement.query.params.GetProfileParams;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IProfileService {
    ProfileFullInfoDto createProfile(UpsertProfileForm upsertProfileForm, MultipartFile file);

    ProfileFullInfoDto getFullInfoProfile(Long id);

    Page<ProfileMinInfoDto> getMinInfoProfile(GetProfileParams getProfileParams, Pageable pageable);

    ProfileFullInfoDto updateProfile(UpsertProfileForm upsertProfileForm, Long id);

    void deleteProfile(Long id);

    void deleteProfilesInIds(List<Long> ids);
}
