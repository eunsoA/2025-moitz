import { useCallback, useEffect } from 'react';
import { useParams, useNavigate } from 'react-router';

import FallBackPage from '@pages/components/fallBackPage/FallBackPage';
import useSelectedRecommendedLocation from '@pages/hooks/useSelectedLocation';

import ProgressLoading from '@features/loading/components/progressLoading/ProgressLoading';
import Map from '@features/map/components/map/Map';
import BottomSheet from '@features/recommendation/components/bottomSheet/BottomSheet';

import { useLocationsContext } from '@entities/location/contexts/useLocationsContext';
import { RecommendedLocation } from '@entities/location/types/Location';

import { flex } from '@shared/styles/default.styled';

import * as resultPage from './resultPage.styled';

function ResultPage() {
  const { id } = useParams<{ id: string }>();
  const navigate = useNavigate();
  const {
    data: location,
    isLoading,
    getRecommendationResult,
  } = useLocationsContext();

  const fetchResult = useCallback(async () => {
    try {
      await getRecommendationResult(id);
    } catch {
      navigate('/');
    }
  }, [id, navigate, getRecommendationResult]);

  useEffect(() => {
    if (!id) {
      navigate('/');
      return;
    }

    fetchResult();
  }, [id, fetchResult]);

  const { selectedLocation, changeSelectedLocation } =
    useSelectedRecommendedLocation();

  const handleSpotClick = (location: RecommendedLocation) => {
    changeSelectedLocation(location);
  };

  if (isLoading) return <ProgressLoading />;
  if (!location || location.recommendedLocations.length === 0)
    return (
      <FallBackPage
        reset={() => {}}
        error={new Error('추천 결과가 없습니다.')}
      />
    );

  const { startingPlaces, recommendedLocations } = location;

  return (
    <div
      css={[
        flex({ direction: 'column', justify: 'flex-end' }),
        resultPage.base(),
      ]}
    >
      <Map
        startingLocations={startingPlaces}
        recommendedLocations={recommendedLocations}
        selectedLocation={selectedLocation}
        changeSelectedLocation={changeSelectedLocation}
      />
      <BottomSheet
        startingLocations={location.startingPlaces}
        recommendedLocations={location.recommendedLocations}
        selectedLocation={selectedLocation}
        handleSpotClick={handleSpotClick}
      />
    </div>
  );
}

export default ResultPage;
