package com.denbinger.headless.vitamins.internal.resource.v1_0;

import com.denbinger.headless.vitamins.dto.v1_0.Vitamin;
import com.denbinger.headless.vitamins.resource.v1_0.VitaminResource;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.ResourceActionLocalService;
import com.liferay.portal.kernel.service.ResourcePermissionLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.batch.engine.VulcanBatchEngineTaskItemDelegate;
import com.liferay.portal.vulcan.batch.engine.resource.VulcanBatchEngineImportTaskResource;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.liferay.portal.vulcan.resource.EntityModelResource;
import com.liferay.portal.vulcan.util.ActionUtil;
import com.liferay.portal.vulcan.util.TransformUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;

import javax.annotation.Generated;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * @author jinos
 * @generated
 */
@Generated("")
@Path("/v1.0")
public abstract class BaseVitaminResourceImpl
	implements EntityModelResource, VitaminResource,
			   VulcanBatchEngineTaskItemDelegate<Vitamin> {

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -X 'GET' 'http://localhost:8080/o/headless-vitamins/v1.0/vitamins'  -u 'test@liferay.com:test'
	 */
	@GET
	@Operation(
		description = "Retrieves the list of vitamins and minerals. Results can be paginated, filtered, searched, and sorted."
	)
	@Override
	@Parameters(
		value = {
			@Parameter(in = ParameterIn.QUERY, name = "search"),
			@Parameter(in = ParameterIn.QUERY, name = "filter"),
			@Parameter(in = ParameterIn.QUERY, name = "page"),
			@Parameter(in = ParameterIn.QUERY, name = "pageSize"),
			@Parameter(in = ParameterIn.QUERY, name = "sort")
		}
	)
	@Path("/vitamins")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "Vitamin")})
	public Page<Vitamin> getVitaminsPage(
			@Parameter(hidden = true) @QueryParam("search") String search,
			@Context Filter filter, @Context Pagination pagination,
			@Context Sort[] sorts)
		throws Exception {

		return Page.of(Collections.emptyList());
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -X 'POST' 'http://localhost:8080/o/headless-vitamins/v1.0/vitamins' -d $'{"articleId": ___, "attributes": ___, "chemicalNames": ___, "creator": ___, "description": ___, "group": ___, "id": ___, "name": ___, "properties": ___, "risks": ___, "symptoms": ___, "type": ___}' --header 'Content-Type: application/json' -u 'test@liferay.com:test'
	 */
	@Consumes({"application/json", "application/xml"})
	@Operation(description = "Create a new vitamin/mineral.")
	@Override
	@Path("/vitamins")
	@POST
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "Vitamin")})
	public Vitamin postVitamin(Vitamin vitamin) throws Exception {
		return new Vitamin();
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -X 'POST' 'http://localhost:8080/o/headless-vitamins/v1.0/vitamins/batch'  -u 'test@liferay.com:test'
	 */
	@Consumes("application/json")
	@Override
	@Parameters(
		value = {@Parameter(in = ParameterIn.QUERY, name = "callbackURL")}
	)
	@Path("/vitamins/batch")
	@POST
	@Produces("application/json")
	@Tags(value = {@Tag(name = "Vitamin")})
	public Response postVitaminBatch(
			@Parameter(hidden = true) @QueryParam("callbackURL")
				String callbackURL,
			Object object)
		throws Exception {

		vulcanBatchEngineImportTaskResource.setContextAcceptLanguage(
			contextAcceptLanguage);
		vulcanBatchEngineImportTaskResource.setContextCompany(contextCompany);
		vulcanBatchEngineImportTaskResource.setContextHttpServletRequest(
			contextHttpServletRequest);
		vulcanBatchEngineImportTaskResource.setContextUriInfo(contextUriInfo);
		vulcanBatchEngineImportTaskResource.setContextUser(contextUser);

		Response.ResponseBuilder responseBuilder = Response.accepted();

		return responseBuilder.entity(
			vulcanBatchEngineImportTaskResource.postImportTask(
				Vitamin.class.getName(), callbackURL, null, object)
		).build();
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -X 'DELETE' 'http://localhost:8080/o/headless-vitamins/v1.0/vitamins/{vitaminId}'  -u 'test@liferay.com:test'
	 */
	@DELETE
	@Operation(
		description = "Deletes the vitamin/mineral and returns a 204 if the operation succeeds."
	)
	@Override
	@Parameters(value = {@Parameter(in = ParameterIn.PATH, name = "vitaminId")})
	@Path("/vitamins/{vitaminId}")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "Vitamin")})
	public void deleteVitamin(
			@NotNull @Parameter(hidden = true) @PathParam("vitaminId")
				String vitaminId)
		throws Exception {
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -X 'DELETE' 'http://localhost:8080/o/headless-vitamins/v1.0/vitamins/batch'  -u 'test@liferay.com:test'
	 */
	@Consumes("application/json")
	@DELETE
	@Override
	@Parameters(
		value = {@Parameter(in = ParameterIn.QUERY, name = "callbackURL")}
	)
	@Path("/vitamins/batch")
	@Produces("application/json")
	@Tags(value = {@Tag(name = "Vitamin")})
	public Response deleteVitaminBatch(
			@Parameter(hidden = true) @QueryParam("callbackURL")
				String callbackURL,
			Object object)
		throws Exception {

		vulcanBatchEngineImportTaskResource.setContextAcceptLanguage(
			contextAcceptLanguage);
		vulcanBatchEngineImportTaskResource.setContextCompany(contextCompany);
		vulcanBatchEngineImportTaskResource.setContextHttpServletRequest(
			contextHttpServletRequest);
		vulcanBatchEngineImportTaskResource.setContextUriInfo(contextUriInfo);
		vulcanBatchEngineImportTaskResource.setContextUser(contextUser);

		Response.ResponseBuilder responseBuilder = Response.accepted();

		return responseBuilder.entity(
			vulcanBatchEngineImportTaskResource.deleteImportTask(
				Vitamin.class.getName(), callbackURL, object)
		).build();
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -X 'GET' 'http://localhost:8080/o/headless-vitamins/v1.0/vitamins/{vitaminId}'  -u 'test@liferay.com:test'
	 */
	@GET
	@Operation(description = "Retrieves the vitamin/mineral via its ID.")
	@Override
	@Parameters(value = {@Parameter(in = ParameterIn.PATH, name = "vitaminId")})
	@Path("/vitamins/{vitaminId}")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "Vitamin")})
	public Vitamin getVitamin(
			@NotNull @Parameter(hidden = true) @PathParam("vitaminId")
				String vitaminId)
		throws Exception {

		return new Vitamin();
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -X 'PATCH' 'http://localhost:8080/o/headless-vitamins/v1.0/vitamins/{vitaminId}' -d $'{"articleId": ___, "attributes": ___, "chemicalNames": ___, "creator": ___, "description": ___, "group": ___, "id": ___, "name": ___, "properties": ___, "risks": ___, "symptoms": ___, "type": ___}' --header 'Content-Type: application/json' -u 'test@liferay.com:test'
	 */
	@Consumes({"application/json", "application/xml"})
	@Operation(
		description = "Replaces the vitamin/mineral with the information sent in the request body. Any missing fields are deleted, unless they are required."
	)
	@Override
	@Parameters(value = {@Parameter(in = ParameterIn.PATH, name = "vitaminId")})
	@PATCH
	@Path("/vitamins/{vitaminId}")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "Vitamin")})
	public Vitamin patchVitamin(
			@NotNull @Parameter(hidden = true) @PathParam("vitaminId")
				String vitaminId,
			Vitamin vitamin)
		throws Exception {

		Vitamin existingVitamin = getVitamin(vitaminId);

		if (vitamin.getArticleId() != null) {
			existingVitamin.setArticleId(vitamin.getArticleId());
		}

		if (vitamin.getAttributes() != null) {
			existingVitamin.setAttributes(vitamin.getAttributes());
		}

		if (vitamin.getChemicalNames() != null) {
			existingVitamin.setChemicalNames(vitamin.getChemicalNames());
		}

		if (vitamin.getDescription() != null) {
			existingVitamin.setDescription(vitamin.getDescription());
		}

		if (vitamin.getGroup() != null) {
			existingVitamin.setGroup(vitamin.getGroup());
		}

		if (vitamin.getName() != null) {
			existingVitamin.setName(vitamin.getName());
		}

		if (vitamin.getProperties() != null) {
			existingVitamin.setProperties(vitamin.getProperties());
		}

		if (vitamin.getRisks() != null) {
			existingVitamin.setRisks(vitamin.getRisks());
		}

		if (vitamin.getSymptoms() != null) {
			existingVitamin.setSymptoms(vitamin.getSymptoms());
		}

		if (vitamin.getType() != null) {
			existingVitamin.setType(vitamin.getType());
		}

		preparePatch(vitamin, existingVitamin);

		return putVitamin(vitaminId, existingVitamin);
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -X 'PUT' 'http://localhost:8080/o/headless-vitamins/v1.0/vitamins/{vitaminId}' -d $'{"articleId": ___, "attributes": ___, "chemicalNames": ___, "creator": ___, "description": ___, "group": ___, "id": ___, "name": ___, "properties": ___, "risks": ___, "symptoms": ___, "type": ___}' --header 'Content-Type: application/json' -u 'test@liferay.com:test'
	 */
	@Consumes({"application/json", "application/xml"})
	@Operation(
		description = "Replaces the vitamin/mineral with the information sent in the request body. Any missing fields are deleted, unless they are required."
	)
	@Override
	@Parameters(value = {@Parameter(in = ParameterIn.PATH, name = "vitaminId")})
	@Path("/vitamins/{vitaminId}")
	@Produces({"application/json", "application/xml"})
	@PUT
	@Tags(value = {@Tag(name = "Vitamin")})
	public Vitamin putVitamin(
			@NotNull @Parameter(hidden = true) @PathParam("vitaminId")
				String vitaminId,
			Vitamin vitamin)
		throws Exception {

		return new Vitamin();
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -X 'PUT' 'http://localhost:8080/o/headless-vitamins/v1.0/vitamins/batch'  -u 'test@liferay.com:test'
	 */
	@Consumes("application/json")
	@Override
	@Parameters(
		value = {@Parameter(in = ParameterIn.QUERY, name = "callbackURL")}
	)
	@Path("/vitamins/batch")
	@Produces("application/json")
	@PUT
	@Tags(value = {@Tag(name = "Vitamin")})
	public Response putVitaminBatch(
			@Parameter(hidden = true) @QueryParam("callbackURL")
				String callbackURL,
			Object object)
		throws Exception {

		vulcanBatchEngineImportTaskResource.setContextAcceptLanguage(
			contextAcceptLanguage);
		vulcanBatchEngineImportTaskResource.setContextCompany(contextCompany);
		vulcanBatchEngineImportTaskResource.setContextHttpServletRequest(
			contextHttpServletRequest);
		vulcanBatchEngineImportTaskResource.setContextUriInfo(contextUriInfo);
		vulcanBatchEngineImportTaskResource.setContextUser(contextUser);

		Response.ResponseBuilder responseBuilder = Response.accepted();

		return responseBuilder.entity(
			vulcanBatchEngineImportTaskResource.putImportTask(
				Vitamin.class.getName(), callbackURL, object)
		).build();
	}

	@Override
	@SuppressWarnings("PMD.UnusedLocalVariable")
	public void create(
			java.util.Collection<Vitamin> vitamins,
			Map<String, Serializable> parameters)
		throws Exception {

		for (Vitamin vitamin : vitamins) {
			postVitamin(vitamin);
		}
	}

	@Override
	public void delete(
			java.util.Collection<Vitamin> vitamins,
			Map<String, Serializable> parameters)
		throws Exception {

		for (Vitamin vitamin : vitamins) {
			deleteVitamin(vitamin.getId());
		}
	}

	@Override
	public EntityModel getEntityModel(Map<String, List<String>> multivaluedMap)
		throws Exception {

		return getEntityModel(
			new MultivaluedHashMap<String, Object>(multivaluedMap));
	}

	@Override
	public EntityModel getEntityModel(MultivaluedMap multivaluedMap)
		throws Exception {

		return null;
	}

	@Override
	public Page<Vitamin> read(
			Filter filter, Pagination pagination, Sort[] sorts,
			Map<String, Serializable> parameters, String search)
		throws Exception {

		return getVitaminsPage(search, filter, pagination, sorts);
	}

	@Override
	public void setLanguageId(String languageId) {
		this.contextAcceptLanguage = new AcceptLanguage() {

			@Override
			public List<Locale> getLocales() {
				return null;
			}

			@Override
			public String getPreferredLanguageId() {
				return languageId;
			}

			@Override
			public Locale getPreferredLocale() {
				return LocaleUtil.fromLanguageId(languageId);
			}

		};
	}

	@Override
	public void update(
			java.util.Collection<Vitamin> vitamins,
			Map<String, Serializable> parameters)
		throws Exception {

		for (Vitamin vitamin : vitamins) {
			putVitamin(
				vitamin.getId() != null ? vitamin.getId() :
					(String)parameters.get("vitaminId"),
				vitamin);
		}
	}

	public void setContextAcceptLanguage(AcceptLanguage contextAcceptLanguage) {
		this.contextAcceptLanguage = contextAcceptLanguage;
	}

	public void setContextCompany(
		com.liferay.portal.kernel.model.Company contextCompany) {

		this.contextCompany = contextCompany;
	}

	public void setContextHttpServletRequest(
		HttpServletRequest contextHttpServletRequest) {

		this.contextHttpServletRequest = contextHttpServletRequest;
	}

	public void setContextHttpServletResponse(
		HttpServletResponse contextHttpServletResponse) {

		this.contextHttpServletResponse = contextHttpServletResponse;
	}

	public void setContextUriInfo(UriInfo contextUriInfo) {
		this.contextUriInfo = contextUriInfo;
	}

	public void setContextUser(
		com.liferay.portal.kernel.model.User contextUser) {

		this.contextUser = contextUser;
	}

	public void setGroupLocalService(GroupLocalService groupLocalService) {
		this.groupLocalService = groupLocalService;
	}

	public void setRoleLocalService(RoleLocalService roleLocalService) {
		this.roleLocalService = roleLocalService;
	}

	protected Map<String, String> addAction(
		String actionName, GroupedModel groupedModel, String methodName) {

		return ActionUtil.addAction(
			actionName, getClass(), groupedModel, methodName,
			contextScopeChecker, contextUriInfo);
	}

	protected Map<String, String> addAction(
		String actionName, Long id, String methodName, Long ownerId,
		String permissionName, Long siteId) {

		return ActionUtil.addAction(
			actionName, getClass(), id, methodName, contextScopeChecker,
			ownerId, permissionName, siteId, contextUriInfo);
	}


	protected Map<String, String> addAction(
		String actionName, String methodName, String permissionName,
		Long siteId) {

		return addAction(
			actionName, siteId, methodName, null, permissionName, siteId);
	}

	protected void preparePatch(Vitamin vitamin, Vitamin existingVitamin) {
	}

	protected <T, R> List<R> transform(
		java.util.Collection<T> collection,
		UnsafeFunction<T, R, Exception> unsafeFunction) {

		return TransformUtil.transform(collection, unsafeFunction);
	}

	protected <T, R> R[] transform(
		T[] array, UnsafeFunction<T, R, Exception> unsafeFunction,
		Class<?> clazz) {

		return TransformUtil.transform(array, unsafeFunction, clazz);
	}

	protected <T, R> R[] transformToArray(
		java.util.Collection<T> collection,
		UnsafeFunction<T, R, Exception> unsafeFunction, Class<?> clazz) {

		return TransformUtil.transformToArray(
			collection, unsafeFunction, clazz);
	}

	protected <T, R> List<R> transformToList(
		T[] array, UnsafeFunction<T, R, Exception> unsafeFunction) {

		return TransformUtil.transformToList(array, unsafeFunction);
	}

	protected AcceptLanguage contextAcceptLanguage;
	protected com.liferay.portal.kernel.model.Company contextCompany;
	protected HttpServletRequest contextHttpServletRequest;
	protected HttpServletResponse contextHttpServletResponse;
	protected Object contextScopeChecker;
	protected UriInfo contextUriInfo;
	protected com.liferay.portal.kernel.model.User contextUser;
	protected GroupLocalService groupLocalService;
	protected ResourceActionLocalService resourceActionLocalService;
	protected ResourcePermissionLocalService resourcePermissionLocalService;
	protected RoleLocalService roleLocalService;
	protected VulcanBatchEngineImportTaskResource
		vulcanBatchEngineImportTaskResource;

}