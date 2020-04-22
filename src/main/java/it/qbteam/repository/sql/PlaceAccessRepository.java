package it.qbteam.repository.sql;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.qbteam.model.PlaceAccess;

@Repository
public interface PlaceAccessRepository extends CrudRepository<PlaceAccess, Long> {
    @Query("from PlaceAccess where orgAuthServerId=:serverId and placeId=:plId")
    public Iterable<PlaceAccess> findByOrgAuthServerIdAndPlaceId(@Param("serverId") String orgAuthServerId, @Param("") Long placeId);
}