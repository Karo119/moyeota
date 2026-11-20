package com.back.team9.moyeota.domain.funding.dto;

import com.back.team9.moyeota.domain.funding.entity.BusType;
import com.back.team9.moyeota.domain.funding.entity.TripType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record FundingCreateRequest(
        @Schema(example = "서울-대전 야구 원정 버스")
        @NotBlank(message = "제목은 필수입니다.")
        String title,
        @Schema(example = "주말 경기 관람 후 당일 복귀하는 일정입니다.")
        String content,

        @Schema(example = "BUS_25")
        @NotNull(message = "버스 종류는 필수입니다.")
        BusType busType,

        @Schema(example = "2")
        @NotNull(message = "최소 인원은 필수입니다.")
        @Positive(message = "최소 인원은 1명 이상이어야 합니다.")
        Integer minParticipants,

        @Schema(example = "ONE_WAY")
        @NotNull(message = "왕복 여부는 필수입니다.")
        TripType tripType,

        @Schema(example = "1A")
        @NotBlank(message = "방장 출발 좌석은 필수입니다.")
        String hostOutboundSeatNumber,

        String hostReturnSeatNumber,

//        @NotEmpty(message = "최소 1개의 노선이 필요합니다.")
//        List<PathinfoCreateRequest> paths
        @NotNull(message = "노선 정보는 필수입니다.")
        @Valid
        RouteRequest route
) {
}
