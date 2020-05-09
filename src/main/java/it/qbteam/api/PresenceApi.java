/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (4.2.3).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package it.qbteam.api;

import it.qbteam.model.OrganizationPresenceCounter;
import it.qbteam.model.PlacePresenceCounter;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.constraints.Min;

@Validated
@Api(value = "presence", description = "the presence API")
public interface PresenceApi {

    /**
     * GET /presence/organization/{organizationId}/counter : Gets the number of people currently inside the organization&#39;s trackingArea.
     * Gets the number of people currently inside the organization&#39;s trackingArea. Only web-app administrators can access this end-point.
     *
     * @param organizationId ID of an organization. (required)
     * @return Organization presence counter returned successfully. (status code 200)
     *         or The administrator is not authenticated. Nothing gets returned. (status code 401)
     *         or The organization could not be found. Nothing gets returned. (status code 404)
     */
    @ApiOperation(value = "Gets the number of people currently inside the organization's trackingArea.", nickname = "getOrganizationPresenceCounter", notes = "Gets the number of people currently inside the organization's trackingArea. Only web-app administrators can access this end-point.", response = OrganizationPresenceCounter.class, authorizations = {
        @Authorization(value = "bearerAuth")
    }, tags={ "presence", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Organization presence counter returned successfully.", response = OrganizationPresenceCounter.class),
        @ApiResponse(code = 401, message = "The administrator is not authenticated. Nothing gets returned."),
        @ApiResponse(code = 403, message = "Users cannot access this end-point. Nothing gets returned."),
        @ApiResponse(code = 404, message = "The organization could not be found. Nothing gets returned.") })
    @RequestMapping(value = "/presence/organization/{organizationId}/counter",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<OrganizationPresenceCounter> getOrganizationPresenceCounter(@Min(1L)@ApiParam(value = "ID of an organization.",required=true) @PathVariable("organizationId") Long organizationId);


    /**
     * GET /presence/place/{placeId}/counter : Gets the number of people currently inside the place&#39;s trackingArea.
     * Gets the number of people currently inside the place&#39;s trackingArea. Only web-app administrators can access this end-point.
     *
     * @param placeId ID of a place. (required)
     * @return Place presence counter returned successfully. (status code 200)
     *         or The administrator is not authenticated. Nothing gets returned. (status code 401)
     *         or The place could not be found. Nothing gets returned. (status code 404)
     */
    @ApiOperation(value = "Gets the number of people currently inside the place's trackingArea.", nickname = "getPlacePresenceCounter", notes = "Gets the number of people currently inside the place's trackingArea. Only web-app administrators can access this end-point.", response = PlacePresenceCounter.class, authorizations = {
        @Authorization(value = "bearerAuth")
    }, tags={ "presence", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Place presence counter returned successfully.", response = PlacePresenceCounter.class),
        @ApiResponse(code = 401, message = "The administrator is not authenticated. Nothing gets returned."),
        @ApiResponse(code = 403, message = "Users cannot access this end-point. Nothing gets returned."),
        @ApiResponse(code = 404, message = "The place could not be found. Nothing gets returned.") })
    @RequestMapping(value = "/presence/place/{placeId}/counter",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<PlacePresenceCounter> getPlacePresenceCounter(@Min(1L)@ApiParam(value = "ID of a place.",required=true) @PathVariable("placeId") Long placeId);

}
