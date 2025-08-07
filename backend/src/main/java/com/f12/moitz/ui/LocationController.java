package com.f12.moitz.ui;

import com.f12.moitz.application.RecommendationService;
import com.f12.moitz.application.dto.PathResponse;
import com.f12.moitz.application.dto.PlaceRecommendResponse;
import com.f12.moitz.application.dto.RecommendationRequest;
import com.f12.moitz.application.dto.RecommendationResponse;
import com.f12.moitz.application.dto.RecommendationsResponse;
import com.f12.moitz.application.dto.RouteResponse;
import com.f12.moitz.application.dto.StartingPlaceResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/locations")
public class LocationController implements SwaggerLocationController {

    private final RecommendationService recommendationService;

    @PostMapping
    public ResponseEntity<RecommendationsResponse> recommendLocations(@RequestBody RecommendationRequest request) {
        return ResponseEntity.ok(recommendationService.recommendLocation(request));
    }

    @PostMapping("/test")
    public ResponseEntity<RecommendationsResponse> mockRecommendedLocation(@RequestBody RecommendationRequest request) {
        return ResponseEntity.ok(mock());
    }

    private RecommendationsResponse mock() {
        return new RecommendationsResponse(
                List.of(
                        new StartingPlaceResponse(1L, 1, 127.094741101863, 37.5351180385975, "강변역"),
                        new StartingPlaceResponse(2L, 2, 127.01063381083677, 37.571669405802616, "동대문역"),
                        new StartingPlaceResponse(3L, 3, 126.952713197762, 37.4812845080678, "서울대입구역")
                ),
                List.of(
                        new RecommendationResponse(1L, 1, 37.54040751726388, 127.06920291650829, "건대입구역", 18, true,
                                "다양한 즐길거리가 가득! 🥳 (식당, 카페, PC방, 노래방, 오락시설)", "어디에서 출발해도 교통이 좋은 중심지이며, 다양한 만남 장소가 존재하는 최적의 장소 중 하나입니다.",
                                List.of(
                                        new PlaceRecommendResponse(1, "육일관", "식당", 1, "http://place.map.kakao.com/1050190897"),
                                        new PlaceRecommendResponse(2, "바나프레소 건대역점", "카페", 1, "http://place.map.kakao.com/666587821"),
                                        new PlaceRecommendResponse(3, "포포PC방 건대점", "PC방", 1, "http://place.map.kakao.com/356960076")
                                ),
                                List.of(
                                        new RouteResponse(1, 0, 4, List.of(
                                                new PathResponse(1, "강변", 127.094687, 37.535092, "건대입구", 127.069276, 37.540364, "2호선", 4)
                                        )),
                                        new RouteResponse(2, 1, 18, List.of(
                                                new PathResponse(1, "동대문", 127.009111, 37.571132, "동대문역사문화공원", 127.007821, 37.565147, "4호선", 2),
                                                new PathResponse(2, "동대문역사문화공원", 127.007821, 37.565147, "동대문역사문화공원", 127.007821, 37.565147, null, 3),
                                                new PathResponse(3, "동대문역사문화공원", 127.008912, 37.56567, "건대입구", 127.069276, 37.540364, "2호선", 13)
                                        )),
                                        new RouteResponse(3, 0, 33, List.of(
                                                new PathResponse(1, "서울대입구", 126.952725, 37.481199, "건대입구", 127.069276, 37.540364, "2호선", 33)
                                        ))
                                )
                        ),
                        new RecommendationResponse(2L, 2, 37.47656223234824, 126.98155858357366, "사당역", 18, true,
                                "만남의 광장, 맛집도 다양! 😋 (식당, 카페, PC방)", "다양한 장소에서 접근하기 편하며, 주어진 카테고리에 대한 요건을 만족하는 가장 추천드리는 선택지입니다.",
                                List.of(
                                        new PlaceRecommendResponse(1, "훈장골 사당점", "식당", 1, "http://place.map.kakao.com/63778027"),
                                        new PlaceRecommendResponse(2, "스타벅스 사당점", "카페", 1, "http://place.map.kakao.com/23447734"),
                                        new PlaceRecommendResponse(3, "레벨업PC방 사당역점", "PC방", 2, "http://place.map.kakao.com/1705311839")
                                ),
                                List.of(
                                        new RouteResponse(1, 0, 25, List.of(
                                                new PathResponse(1, "강변", 127.094687, 37.535092, "사당", 126.981359, 37.476575, "2호선", 25)
                                        )),
                                        new RouteResponse(2, 0, 25, List.of(
                                                new PathResponse(1, "동대문", 127.009111, 37.571132, "사당", 126.981662, 37.476793, "4호선", 25)
                                        )),
                                        new RouteResponse(3, 0, 4, List.of(
                                                new PathResponse(1, "서울대입구", 126.952725, 37.481199, "사당", 126.981359, 37.476575, "2호선", 4)
                                        ))
                                )
                        ),
                        new RecommendationResponse(3L, 3, 37.561268363317176, 127.03710337610202, "왕십리역", 18, true,
                                "교통 요충지, 엔터-식사 해결! ✨ (식당, 카페, PC방, 노래방, 오락시설)", "어디에서 출발해도 교통이 좋은 중심지이며, 다양한 만남 장소가 존재하는 최적의 장소 중 하나입니다.",
                                List.of(
                                        new PlaceRecommendResponse(1, "스시도쿠", "식당", 1, "http://place.map.kakao.com/26792732"),
                                        new PlaceRecommendResponse(2, "탐앤탐스 왕십리역점", "카페", 1, "http://place.map.kakao.com/10809505"),
                                        new PlaceRecommendResponse(3, "이스포츠PC방 왕십리점", "PC방", 2, "http://place.map.kakao.com/12326220")
                                ),
                                List.of(
                                        new RouteResponse(1, 0, 11, List.of(
                                                new PathResponse(1, "강변", 127.094687, 37.535092, "왕십리", 127.037245, 37.561219, "2호선", 11)
                                        )),
                                        new RouteResponse(2, 1, 11, List.of(
                                                new PathResponse(1, "동대문", 127.009111, 37.571132, "동대문역사문화공원", 127.007821, 37.565147, "4호선", 2),
                                                new PathResponse(2, "동대문역사문화공원", 127.007821, 37.565147, "동대문역사문화공원", 127.007821, 37.565147, null, 3),
                                                new PathResponse(3, "동대문역사문화공원", 127.008912, 37.56567, "왕십리", 127.037245, 37.561219, "2호선", 6)
                                        )),
                                        new RouteResponse(3, 1, 32, List.of(
                                                new PathResponse(1, "서울대입구", 126.952725, 37.481199, "선릉", 127.049271, 37.504577, "2호선", 16),
                                                new PathResponse(2, "선릉", 127.049271, 37.504577, "선릉", 127.049271, 37.504577, null, 3),
                                                new PathResponse(3, "선릉", 127.048606, 37.505274, "왕십리", 127.038702, 37.561501, "수인분당선", 13)
                                        ))
                                )
                        ),
                        new RecommendationResponse(4L, 4, 37.570227990912244, 126.98315081716676, "종각역", 24, false,
                                "젊음의 거리, 핫플집합소! 😉 (식당, 카페, PC방, 노래방)", "다양한 장소에서 접근하기 편하며, 주어진 카테고리에 대한 요건을 만족하는 가장 추천드리는 선택지입니다.",
                                List.of(
                                        new PlaceRecommendResponse(1, "스타벅스 종로R점", "카페", 1, "http://place.map.kakao.com/1784996243"),
                                        new PlaceRecommendResponse(2, "한우공방", "식당", 1, "http://place.map.kakao.com/886708185"),
                                        new PlaceRecommendResponse(3, "옵티멈존 PC카페 종각역점", "PC방", 1, "http://place.map.kakao.com/1342335656")
                                ),
                                List.of(
                                        new RouteResponse(1, 2, 32, List.of(
                                                new PathResponse(1, "강변", 127.094687, 37.535092, "을지로3가", 126.991041, 37.566285, "2호선", 19),
                                                new PathResponse(2, "을지로3가", 126.991041, 37.566285, "을지로3가", 126.991041, 37.566285, null, 3),
                                                new PathResponse(3, "을지로3가", 126.992625, 37.566379, "종로3가", 126.991841, 37.571653, "3호선", 4),
                                                new PathResponse(4, "종로3가", 126.991841, 37.571653, "종로3가", 126.991841, 37.571653, null, 3),
                                                new PathResponse(5, "종로3가", 126.99214, 37.57043, "종각", 126.983189, 37.570173, "1호선", 3)
                                        )),
                                        new RouteResponse(2, 0, 5, List.of(
                                                new PathResponse(1, "동대문", 127.010666, 37.571686, "종각", 126.983189, 37.570173, "1호선", 5)
                                        )),
                                        new RouteResponse(3, 2, 36, List.of(
                                                new PathResponse(1, "서울대입구", 126.952725, 37.481199, "사당", 126.981359, 37.476575, "2호선", 4),
                                                new PathResponse(2, "사당", 126.981359, 37.476575, "사당", 126.981359, 37.476575, null, 3),
                                                new PathResponse(3, "사당", 126.981662, 37.476793, "서울역", 126.972709, 37.553512, "4호선", 18),
                                                new PathResponse(4, "서울역", 126.972709, 37.553512, "서울역", 126.972709, 37.553512, null, 3),
                                                new PathResponse(5, "서울역", 126.972314, 37.555942, "종각", 126.983189, 37.570173, "1호선", 8)
                                        ))
                                )
                        ),
                        new RecommendationResponse(5L, 5, 37.5568707448873, 126.923778562273, "홍대입구역", 27, false,
                                "젊음의 거리, 놀거리 천국! 😎 (식당, 카페, PC방, 노래방, 오락시설)", "젊음과 문화의 거리인 홍대입구, 적절히 요소들을 잘 고려했습니다.",
                                List.of(
                                        new PlaceRecommendResponse(1, "하이디라오 홍대지점", "음식점", 1, "http://place.map.kakao.com/1622865435"),
                                        new PlaceRecommendResponse(2, "1984", "카페", 1, "http://place.map.kakao.com/23634722"),
                                        new PlaceRecommendResponse(3, "에스엔에스 피씨SNS PC", "PC방", 1, "http://place.map.kakao.com/798252372")
                                ),
                                List.of(
                                        new RouteResponse(1, 0, 34, List.of(
                                                new PathResponse(1, "강변", 127.094687, 37.535092, "홍대입구", 126.924016, 37.557008, "2호선", 34)
                                        )),
                                        new RouteResponse(2, 1, 24, List.of(
                                                new PathResponse(1, "동대문", 127.009111, 37.571132, "동대문역사문화공원", 127.007821, 37.565147, "4호선", 2),
                                                new PathResponse(2, "동대문역사문화공원", 127.007821, 37.565147, "동대문역사문화공원", 127.007821, 37.565147, null, 3),
                                                new PathResponse(3, "동대문역사문화공원", 127.008912, 37.56567, "홍대입구", 126.924016, 37.557008, "2호선", 19)
                                        )),
                                        new RouteResponse(3, 0, 25, List.of(
                                                new PathResponse(1, "서울대입구", 126.952725, 37.481199, "홍대입구", 126.924016, 37.557008, "2호선", 25)
                                        ))
                                )
                        )
                )
        );
    }

}
