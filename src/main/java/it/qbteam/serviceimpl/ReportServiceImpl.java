package it.qbteam.serviceimpl;

import it.qbteam.model.Organization;
import it.qbteam.model.OrganizationAccess;
import it.qbteam.model.TimePerUserReport;
import it.qbteam.repository.sql.OrganizationAccessRepository;
import it.qbteam.repository.sql.PlaceAccessRepository;
import it.qbteam.service.ReportService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.*;

@Service
public class ReportServiceImpl implements ReportService {

    private OrganizationAccessRepository organizationAccessRepo;
    private PlaceAccessRepository placeAccessRepo;

    @Override
    public List<TimePerUserReport> getTimePerUserReport(Long organizationId) {
        Iterable<OrganizationAccess> allAccessOfSingleOrganization = organizationAccessRepo.findByOrganizationId(organizationId);
        List<OrganizationAccess> listOfAllAccessOnOrganization = new ArrayList<>();
        allAccessOfSingleOrganization.forEach(listOfAllAccessOnOrganization::add);
        listOfAllAccessOnOrganization.stream().map(orgAccess-> new TimePerUserReport().organizationId(orgAccess.getOrganizationId()).orgAuthServerId(orgAccess.getOrgAuthServerId()).totalTime(
                orgAccess.getExitTimestamp()
                        .minusSeconds(orgAccess.getEntranceTimestamp().toInstant().toEpochMilli()))).reduce(new TimePerUserReport().setTotalTime(OffsetDateTime.of(LocalDateTime.of(0, 00, 00, 00, 00),
                ZoneOffset.ofHoursMinutes(0, 0))), );

    }
}
