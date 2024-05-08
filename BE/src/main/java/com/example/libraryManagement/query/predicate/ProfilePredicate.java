package com.example.libraryManagement.query.predicate;

import com.example.libraryManagement.Utils.CommonUtils;
import com.example.libraryManagement.model.entity.QProfile;
import com.example.libraryManagement.query.params.GetProfileParams;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

public class ProfilePredicate {
    private static QProfile profile = QProfile.profile;
    public static BooleanBuilder getProfiles(GetProfileParams getProfileParams){
        BooleanBuilder where = new BooleanBuilder();
        return where
                .and(doBInBetween(getProfileParams.getFrom(),getProfileParams.getTo()))
                .and(commonAttributeContainKeyword(getProfileParams.getKeyword()));
    };

    private static BooleanExpression commonAttributeContainKeyword(String keyword){
        return StringUtils.isNotBlank(keyword) ?
                profile.name.containsIgnoreCase(keyword)
                        .and(profile.CCCD_ID.containsIgnoreCase(keyword))
                        .and(profile.address.containsIgnoreCase(keyword))
                        .and(profile.email.containsIgnoreCase(keyword))
                        .and(profile.phone.containsIgnoreCase(keyword)) : null;

    }
    private static BooleanExpression doBInBetween(Date from, Date to){
        return CommonUtils.validateDateBetween(from,to) ?
                profile.DoB.between(from,to):null;
    }
}
