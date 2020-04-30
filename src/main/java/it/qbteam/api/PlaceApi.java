/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (4.2.3).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package it.qbteam.api;

import it.qbteam.model.Place;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@Validated
@Api(value = "place", description = "the place API")
public interface PlaceApi {

    /**
     * POST /place : Creates a new place for an organization.
     * Creates a new place for an organization. Only web-app administrators can access this end-point.
     *
     * @param place  (required)
     * @return The new place of the organization was created. The place gets returned. (status code 201)
     *         or The new tracking area does not respect the area constraints for the organization. Nothing gets returned. (status code 400)
     *         or The administrator is not authenticated. Nothing gets returned. (status code 401)
     *         or Users or administrator with viewer permission cannot have access. Nothing gets returned. (status code 403)
     */
    @ApiOperation(value = "Creates a new place for an organization.", nickname = "createNewPlace", notes = "Creates a new place for an organization. Only web-app administrators can access this end-point.", response = Place.class, authorizations = {
        @Authorization(value = "bearerAuth")
    }, tags={ "place", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "The new place of the organization was created. The place gets returned.", response = Place.class),
        @ApiResponse(code = 400, message = "The new tracking area does not respect the area constraints for the organization. Nothing gets returned."),
        @ApiResponse(code = 401, message = "The administrator is not authenticated. Nothing gets returned."),
        @ApiResponse(code = 403, message = "Users or administrator with viewer permission cannot have access. Nothing gets returned.") })
    @RequestMapping(value = "/place",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Place> createNewPlace(@ApiParam(value = "" ,required=true )  @Valid @RequestBody Place place);


    /**
     * DELETE /place/{placeId} : Deletes a place of an organization.
     * Deletes a place of an organization. Only web-app administrators can access this end-point.
     *
     * @param placeId ID of a place. (required)
     * @return Place successfully removed from the list of places of the organization. Nothing gets returned. (status code 205)
     *         or The administrator is not authenticated. Nothing gets returned. (status code 401)
     *         or Administrators cannot have access. Nothing gets returned. (status code 403)
     *         or The organization could not be found. Nothing gets returned. (status code 404)
     */
    @ApiOperation(value = "Deletes a place of an organization.", nickname = "deletePlace", notes = "Deletes a place of an organization. Only web-app administrators can access this end-point.", authorizations = {
        @Authorization(value = "bearerAuth")
    }, tags={ "place", })
    @ApiResponses(value = { 
        @ApiResponse(code = 205, message = "Place successfully removed from the list of places of the organization. Nothing gets returned."),
        @ApiResponse(code = 401, message = "The administrator is not authenticated. Nothing gets returned."),
        @ApiResponse(code = 403, message = "Administrators cannot have access. Nothing gets returned."),
        @ApiResponse(code = 404, message = "The organization could not be found. Nothing gets returned.") })
    @RequestMapping(value = "/place/{placeId}",
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deletePlace(@Min(1L)@ApiParam(value = "ID of a place.",required=true) @PathVariable("placeId") Long placeId);


    /**
     * GET /place/organization/{organizationId} : Returns the list of places of the organization.
     * Returns the list of places of the organization. Both app users and web-app administrators can access this end-point.
     *
     * @param organizationId ID of an organization. (required)
     * @return Place list of organization returned successfully. (status code 200)
     *         or Place list of organization is empty. Nothing gets returned. (status code 204)
     *         or The administrator or the user is not authenticated. Nothing gets returned. (status code 401)
     *         or Administrators who are not bound to the organization cannot access this end-point. Nothing gets returned. (status code 403)
     *         or The organization could not be found. Nothing gets returned. (status code 404)
     */
    @ApiOperation(value = "Returns the list of places of the organization.", nickname = "getPlaceListOfOrganization", notes = "Returns the list of places of the organization. Both app users and web-app administrators can access this end-point.", response = Place.class, responseContainer = "List", authorizations = {
        @Authorization(value = "bearerAuth")
    }, tags={ "place", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Place list of organization returned successfully.", response = Place.class, responseContainer = "List"),
        @ApiResponse(code = 204, message = "Place list of organization is empty. Nothing gets returned."),
        @ApiResponse(code = 401, message = "The administrator or the user is not authenticated. Nothing gets returned."),
        @ApiResponse(code = 403, message = "Administrators who are not bound to the organization cannot access this end-point. Nothing gets returned."),
        @ApiResponse(code = 404, message = "The organization could not be found. Nothing gets returned.") })
    @RequestMapping(value = "/place/organization/{organizationId}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Place>> getPlaceListOfOrganization(@Min(1L)@ApiParam(value = "ID of an organization.",required=true) @PathVariable("organizationId") Long organizationId);


    /**
     * PUT /place/{placeId} : Updates one or more properties of a place of an organization.
     * Updates one or more properties of a place of an organization. Only web-app administrators can access this end-point.
     *
     * @param placeId ID of a place. (required)
     * @param place  (required)
     * @return Place updated successfully. The updated place gets returned. (status code 200)
     *         or The inserted data has some issues. Nothing gets returned. (status code 400)
     *         or The administrator is not authenticated. Nothing gets returned. (status code 401)
     *         or Users or administrator with viewer permission cannot have access. Nothing gets returned. (status code 403)
     *         or Invalid place ID supplied. Nothing gets returned. (status code 404)
     */
    @ApiOperation(value = "Updates one or more properties of a place of an organization.", nickname = "updatePlace", notes = "Updates one or more properties of a place of an organization. Only web-app administrators can access this end-point.", response = Place.class, authorizations = {
        @Authorization(value = "bearerAuth")
    }, tags={ "place", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Place updated successfully. The updated place gets returned.", response = Place.class),
        @ApiResponse(code = 400, message = "The inserted data has some issues. Nothing gets returned."),
        @ApiResponse(code = 401, message = "The administrator is not authenticated. Nothing gets returned."),
        @ApiResponse(code = 403, message = "Users or administrator with viewer permission cannot have access. Nothing gets returned."),
        @ApiResponse(code = 404, message = "Invalid place ID supplied. Nothing gets returned.") })
    @RequestMapping(value = "/place/{placeId}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<Place> updatePlace(@Min(1L)@ApiParam(value = "ID of a place.",required=true) @PathVariable("placeId") Long placeId,@ApiParam(value = "" ,required=true )  @Valid @RequestBody Place place);

}
