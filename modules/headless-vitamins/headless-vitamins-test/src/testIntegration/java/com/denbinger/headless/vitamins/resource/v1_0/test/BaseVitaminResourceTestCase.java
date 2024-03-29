package com.denbinger.headless.vitamins.resource.v1_0.test;

import com.denbinger.headless.vitamins.client.dto.v1_0.Vitamin;
import com.denbinger.headless.vitamins.client.http.HttpInvoker;
import com.denbinger.headless.vitamins.client.pagination.Page;
import com.denbinger.headless.vitamins.client.pagination.Pagination;
import com.denbinger.headless.vitamins.client.resource.v1_0.VitaminResource;
import com.denbinger.headless.vitamins.client.serdes.v1_0.VitaminSerDes;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;
import com.liferay.petra.function.UnsafeTriConsumer;
import com.liferay.petra.reflect.ReflectionUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.test.util.GroupTestUtil;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.search.test.util.SearchTestRule;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.vulcan.resource.EntityModelResource;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.lang.time.DateUtils;
import org.junit.*;

import javax.annotation.Generated;
import javax.ws.rs.core.MultivaluedHashMap;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author jinos
 * @generated
 */
@Generated("")
public abstract class BaseVitaminResourceTestCase {

	@ClassRule
	@Rule
	public static final LiferayIntegrationTestRule liferayIntegrationTestRule =
		new LiferayIntegrationTestRule();

	@BeforeClass
	public static void setUpClass() throws Exception {
		_dateFormat = DateFormatFactoryUtil.getSimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");
	}

	@Before
	public void setUp() throws Exception {
		irrelevantGroup = GroupTestUtil.addGroup();
		testGroup = GroupTestUtil.addGroup();

		testCompany = CompanyLocalServiceUtil.getCompany(
			testGroup.getCompanyId());

		_vitaminResource.setContextCompany(testCompany);

		VitaminResource.Builder builder = VitaminResource.builder();

		vitaminResource = builder.authentication(
			"test@liferay.com", "test"
		).locale(
			LocaleUtil.getDefault()
		).build();
	}

	@After
	public void tearDown() throws Exception {
		GroupTestUtil.deleteGroup(irrelevantGroup);
		GroupTestUtil.deleteGroup(testGroup);
	}

	@Test
	public void testClientSerDesToDTO() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper() {
			{
				configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
				configure(
					SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
				enable(SerializationFeature.INDENT_OUTPUT);
				setDateFormat(new ISO8601DateFormat());
				setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
				setSerializationInclusion(JsonInclude.Include.NON_NULL);
				setVisibility(
					PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
				setVisibility(
					PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
			}
		};

		Vitamin vitamin1 = randomVitamin();

		String json = objectMapper.writeValueAsString(vitamin1);

		Vitamin vitamin2 = VitaminSerDes.toDTO(json);

		Assert.assertTrue(equals(vitamin1, vitamin2));
	}

	@Test
	public void testClientSerDesToJSON() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper() {
			{
				configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
				configure(
					SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
				setDateFormat(new ISO8601DateFormat());
				setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
				setSerializationInclusion(JsonInclude.Include.NON_NULL);
				setVisibility(
					PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
				setVisibility(
					PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
			}
		};

		Vitamin vitamin = randomVitamin();

		String json1 = objectMapper.writeValueAsString(vitamin);
		String json2 = VitaminSerDes.toJSON(vitamin);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testEscapeRegexInStringFields() throws Exception {
		String regex = "^[0-9]+(\\.[0-9]{1,2})\"?";

		Vitamin vitamin = randomVitamin();

		vitamin.setArticleId(regex);
		vitamin.setDescription(regex);
		vitamin.setGroup(regex);
		vitamin.setId(regex);
		vitamin.setName(regex);

		String json = VitaminSerDes.toJSON(vitamin);

		Assert.assertFalse(json.contains(regex));

		vitamin = VitaminSerDes.toDTO(json);

		Assert.assertEquals(regex, vitamin.getArticleId());
		Assert.assertEquals(regex, vitamin.getDescription());
		Assert.assertEquals(regex, vitamin.getGroup());
		Assert.assertEquals(regex, vitamin.getId());
		Assert.assertEquals(regex, vitamin.getName());
	}

	@Test
	public void testGetVitaminsPage() throws Exception {
		Page<Vitamin> page = vitaminResource.getVitaminsPage(
			RandomTestUtil.randomString(), null, Pagination.of(1, 2), null);

		Assert.assertEquals(0, page.getTotalCount());

		Vitamin vitamin1 = testGetVitaminsPage_addVitamin(randomVitamin());

		Vitamin vitamin2 = testGetVitaminsPage_addVitamin(randomVitamin());

		page = vitaminResource.getVitaminsPage(
			null, null, Pagination.of(1, 2), null);

		Assert.assertEquals(2, page.getTotalCount());

		assertEqualsIgnoringOrder(
			Arrays.asList(vitamin1, vitamin2), (List<Vitamin>)page.getItems());
		assertValid(page);

		vitaminResource.deleteVitamin(vitamin1.getId());

		vitaminResource.deleteVitamin(vitamin2.getId());
	}

	@Test
	public void testGetVitaminsPageWithFilterDateTimeEquals() throws Exception {
		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.DATE_TIME);

		if (entityFields.isEmpty()) {
			return;
		}

		Vitamin vitamin1 = randomVitamin();

		vitamin1 = testGetVitaminsPage_addVitamin(vitamin1);

		for (EntityField entityField : entityFields) {
			Page<Vitamin> page = vitaminResource.getVitaminsPage(
				null, getFilterString(entityField, "between", vitamin1),
				Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(vitamin1),
				(List<Vitamin>)page.getItems());
		}
	}

	@Test
	public void testGetVitaminsPageWithFilterStringEquals() throws Exception {
		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.STRING);

		if (entityFields.isEmpty()) {
			return;
		}

		Vitamin vitamin1 = testGetVitaminsPage_addVitamin(randomVitamin());

		@SuppressWarnings("PMD.UnusedLocalVariable")
		Vitamin vitamin2 = testGetVitaminsPage_addVitamin(randomVitamin());

		for (EntityField entityField : entityFields) {
			Page<Vitamin> page = vitaminResource.getVitaminsPage(
				null, getFilterString(entityField, "eq", vitamin1),
				Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(vitamin1),
				(List<Vitamin>)page.getItems());
		}
	}

	@Test
	public void testGetVitaminsPageWithPagination() throws Exception {
		Vitamin vitamin1 = testGetVitaminsPage_addVitamin(randomVitamin());

		Vitamin vitamin2 = testGetVitaminsPage_addVitamin(randomVitamin());

		Vitamin vitamin3 = testGetVitaminsPage_addVitamin(randomVitamin());

		Page<Vitamin> page1 = vitaminResource.getVitaminsPage(
			null, null, Pagination.of(1, 2), null);

		List<Vitamin> vitamins1 = (List<Vitamin>)page1.getItems();

		Assert.assertEquals(vitamins1.toString(), 2, vitamins1.size());

		Page<Vitamin> page2 = vitaminResource.getVitaminsPage(
			null, null, Pagination.of(2, 2), null);

		Assert.assertEquals(3, page2.getTotalCount());

		List<Vitamin> vitamins2 = (List<Vitamin>)page2.getItems();

		Assert.assertEquals(vitamins2.toString(), 1, vitamins2.size());

		Page<Vitamin> page3 = vitaminResource.getVitaminsPage(
			null, null, Pagination.of(1, 3), null);

		assertEqualsIgnoringOrder(
			Arrays.asList(vitamin1, vitamin2, vitamin3),
			(List<Vitamin>)page3.getItems());
	}

	@Test
	public void testGetVitaminsPageWithSortDateTime() throws Exception {
		testGetVitaminsPageWithSort(
			EntityField.Type.DATE_TIME,
			(entityField, vitamin1, vitamin2) -> {
				BeanUtils.setProperty(
					vitamin1, entityField.getName(),
					DateUtils.addMinutes(new Date(), -2));
			});
	}

	@Test
	public void testGetVitaminsPageWithSortInteger() throws Exception {
		testGetVitaminsPageWithSort(
			EntityField.Type.INTEGER,
			(entityField, vitamin1, vitamin2) -> {
				BeanUtils.setProperty(vitamin1, entityField.getName(), 0);
				BeanUtils.setProperty(vitamin2, entityField.getName(), 1);
			});
	}

	@Test
	public void testGetVitaminsPageWithSortString() throws Exception {
		testGetVitaminsPageWithSort(
			EntityField.Type.STRING,
			(entityField, vitamin1, vitamin2) -> {
				Class<?> clazz = vitamin1.getClass();

				String entityFieldName = entityField.getName();

				Method method = clazz.getMethod(
					"get" + StringUtil.upperCaseFirstLetter(entityFieldName));

				Class<?> returnType = method.getReturnType();

				if (returnType.isAssignableFrom(Map.class)) {
					BeanUtils.setProperty(
						vitamin1, entityFieldName,
						Collections.singletonMap("Aaa", "Aaa"));
					BeanUtils.setProperty(
						vitamin2, entityFieldName,
						Collections.singletonMap("Bbb", "Bbb"));
				}
				else if (entityFieldName.contains("email")) {
					BeanUtils.setProperty(
						vitamin1, entityFieldName,
						"aaa" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()) +
									"@liferay.com");
					BeanUtils.setProperty(
						vitamin2, entityFieldName,
						"bbb" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()) +
									"@liferay.com");
				}
				else {
					BeanUtils.setProperty(
						vitamin1, entityFieldName,
						"aaa" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()));
					BeanUtils.setProperty(
						vitamin2, entityFieldName,
						"bbb" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()));
				}
			});
	}

	protected void testGetVitaminsPageWithSort(
			EntityField.Type type,
			UnsafeTriConsumer<EntityField, Vitamin, Vitamin, Exception>
				unsafeTriConsumer)
		throws Exception {

		List<EntityField> entityFields = getEntityFields(type);

		if (entityFields.isEmpty()) {
			return;
		}

		Vitamin vitamin1 = randomVitamin();
		Vitamin vitamin2 = randomVitamin();

		for (EntityField entityField : entityFields) {
			unsafeTriConsumer.accept(entityField, vitamin1, vitamin2);
		}

		vitamin1 = testGetVitaminsPage_addVitamin(vitamin1);

		vitamin2 = testGetVitaminsPage_addVitamin(vitamin2);

		for (EntityField entityField : entityFields) {
			Page<Vitamin> ascPage = vitaminResource.getVitaminsPage(
				null, null, Pagination.of(1, 2),
				entityField.getName() + ":asc");

			assertEquals(
				Arrays.asList(vitamin1, vitamin2),
				(List<Vitamin>)ascPage.getItems());

			Page<Vitamin> descPage = vitaminResource.getVitaminsPage(
				null, null, Pagination.of(1, 2),
				entityField.getName() + ":desc");

			assertEquals(
				Arrays.asList(vitamin2, vitamin1),
				(List<Vitamin>)descPage.getItems());
		}
	}

	protected Vitamin testGetVitaminsPage_addVitamin(Vitamin vitamin)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGraphQLGetVitaminsPage() throws Exception {
		GraphQLField graphQLField = new GraphQLField(
			"vitamins",
			new HashMap<String, Object>() {
				{
					put("page", 1);
					put("pageSize", 2);
				}
			},
			new GraphQLField("items", getGraphQLFields()),
			new GraphQLField("page"), new GraphQLField("totalCount"));

		JSONObject vitaminsJSONObject = JSONUtil.getValueAsJSONObject(
			invokeGraphQLQuery(graphQLField), "JSONObject/data",
			"JSONObject/vitamins");

		Assert.assertEquals(0, vitaminsJSONObject.get("totalCount"));

		Vitamin vitamin1 = testGraphQLVitamin_addVitamin();
		Vitamin vitamin2 = testGraphQLVitamin_addVitamin();

		vitaminsJSONObject = JSONUtil.getValueAsJSONObject(
			invokeGraphQLQuery(graphQLField), "JSONObject/data",
			"JSONObject/vitamins");

		Assert.assertEquals(2, vitaminsJSONObject.get("totalCount"));

		assertEqualsIgnoringOrder(
			Arrays.asList(vitamin1, vitamin2),
			Arrays.asList(
				VitaminSerDes.toDTOs(vitaminsJSONObject.getString("items"))));
	}

	@Test
	public void testPostVitamin() throws Exception {
		Vitamin randomVitamin = randomVitamin();

		Vitamin postVitamin = testPostVitamin_addVitamin(randomVitamin);

		assertEquals(randomVitamin, postVitamin);
		assertValid(postVitamin);
	}

	protected Vitamin testPostVitamin_addVitamin(Vitamin vitamin)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testDeleteVitamin() throws Exception {
		@SuppressWarnings("PMD.UnusedLocalVariable")
		Vitamin vitamin = testDeleteVitamin_addVitamin();

		assertHttpResponseStatusCode(
			204, vitaminResource.deleteVitaminHttpResponse(vitamin.getId()));

		assertHttpResponseStatusCode(
			404, vitaminResource.getVitaminHttpResponse(vitamin.getId()));

		assertHttpResponseStatusCode(
			404, vitaminResource.getVitaminHttpResponse("-"));
	}

	protected Vitamin testDeleteVitamin_addVitamin() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGraphQLDeleteVitamin() throws Exception {
		Vitamin vitamin = testGraphQLVitamin_addVitamin();

		Assert.assertTrue(
			JSONUtil.getValueAsBoolean(
				invokeGraphQLMutation(
					new GraphQLField(
						"deleteVitamin",
						new HashMap<String, Object>() {
							{
								put("vitaminId", "\"" + vitamin.getId() + "\"");
							}
						})),
				"JSONObject/data", "Object/deleteVitamin"));

		JSONArray errorsJSONArray = JSONUtil.getValueAsJSONArray(
			invokeGraphQLQuery(
				new GraphQLField(
					"vitamin",
					new HashMap<String, Object>() {
						{
							put("vitaminId", "\"" + vitamin.getId() + "\"");
						}
					},
					new GraphQLField("id"))),
			"JSONArray/errors");

		Assert.assertTrue(errorsJSONArray.length() > 0);
	}

	@Test
	public void testGetVitamin() throws Exception {
		Vitamin postVitamin = testGetVitamin_addVitamin();

		Vitamin getVitamin = vitaminResource.getVitamin(postVitamin.getId());

		assertEquals(postVitamin, getVitamin);
		assertValid(getVitamin);
	}

	protected Vitamin testGetVitamin_addVitamin() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGraphQLGetVitamin() throws Exception {
		Vitamin vitamin = testGraphQLVitamin_addVitamin();

		Assert.assertTrue(
			equals(
				vitamin,
				VitaminSerDes.toDTO(
					JSONUtil.getValueAsString(
						invokeGraphQLQuery(
							new GraphQLField(
								"vitamin",
								new HashMap<String, Object>() {
									{
										put(
											"vitaminId",
											"\"" + vitamin.getId() + "\"");
									}
								},
								getGraphQLFields())),
						"JSONObject/data", "Object/vitamin"))));
	}

	@Test
	public void testGraphQLGetVitaminNotFound() throws Exception {
		String irrelevantVitaminId =
			"\"" + RandomTestUtil.randomString() + "\"";

		Assert.assertEquals(
			"Not Found",
			JSONUtil.getValueAsString(
				invokeGraphQLQuery(
					new GraphQLField(
						"vitamin",
						new HashMap<String, Object>() {
							{
								put("vitaminId", irrelevantVitaminId);
							}
						},
						getGraphQLFields())),
				"JSONArray/errors", "Object/0", "JSONObject/extensions",
				"Object/code"));
	}

	@Test
	public void testPatchVitamin() throws Exception {
		Vitamin postVitamin = testPatchVitamin_addVitamin();

		Vitamin randomPatchVitamin = randomPatchVitamin();

		@SuppressWarnings("PMD.UnusedLocalVariable")
		Vitamin patchVitamin = vitaminResource.patchVitamin(
			postVitamin.getId(), randomPatchVitamin);

		Vitamin expectedPatchVitamin = postVitamin.clone();

		_beanUtilsBean.copyProperties(expectedPatchVitamin, randomPatchVitamin);

		Vitamin getVitamin = vitaminResource.getVitamin(patchVitamin.getId());

		assertEquals(expectedPatchVitamin, getVitamin);
		assertValid(getVitamin);
	}

	protected Vitamin testPatchVitamin_addVitamin() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testPutVitamin() throws Exception {
		Vitamin postVitamin = testPutVitamin_addVitamin();

		Vitamin randomVitamin = randomVitamin();

		Vitamin putVitamin = vitaminResource.putVitamin(
			postVitamin.getId(), randomVitamin);

		assertEquals(randomVitamin, putVitamin);
		assertValid(putVitamin);

		Vitamin getVitamin = vitaminResource.getVitamin(putVitamin.getId());

		assertEquals(randomVitamin, getVitamin);
		assertValid(getVitamin);
	}

	protected Vitamin testPutVitamin_addVitamin() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Rule
	public SearchTestRule searchTestRule = new SearchTestRule();

	protected Vitamin testGraphQLVitamin_addVitamin() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(Vitamin vitamin1, Vitamin vitamin2) {
		Assert.assertTrue(
			vitamin1 + " does not equal " + vitamin2,
			equals(vitamin1, vitamin2));
	}

	protected void assertEquals(
		List<Vitamin> vitamins1, List<Vitamin> vitamins2) {

		Assert.assertEquals(vitamins1.size(), vitamins2.size());

		for (int i = 0; i < vitamins1.size(); i++) {
			Vitamin vitamin1 = vitamins1.get(i);
			Vitamin vitamin2 = vitamins2.get(i);

			assertEquals(vitamin1, vitamin2);
		}
	}

	protected void assertEqualsIgnoringOrder(
		List<Vitamin> vitamins1, List<Vitamin> vitamins2) {

		Assert.assertEquals(vitamins1.size(), vitamins2.size());

		for (Vitamin vitamin1 : vitamins1) {
			boolean contains = false;

			for (Vitamin vitamin2 : vitamins2) {
				if (equals(vitamin1, vitamin2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				vitamins2 + " does not contain " + vitamin1, contains);
		}
	}

	protected void assertValid(Vitamin vitamin) throws Exception {
		boolean valid = true;

		if (vitamin.getId() == null) {
			valid = false;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("articleId", additionalAssertFieldName)) {
				if (vitamin.getArticleId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("attributes", additionalAssertFieldName)) {
				if (vitamin.getAttributes() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("chemicalNames", additionalAssertFieldName)) {
				if (vitamin.getChemicalNames() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("creator", additionalAssertFieldName)) {
				if (vitamin.getCreator() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("description", additionalAssertFieldName)) {
				if (vitamin.getDescription() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("group", additionalAssertFieldName)) {
				if (vitamin.getGroup() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("name", additionalAssertFieldName)) {
				if (vitamin.getName() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("properties", additionalAssertFieldName)) {
				if (vitamin.getProperties() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("risks", additionalAssertFieldName)) {
				if (vitamin.getRisks() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("symptoms", additionalAssertFieldName)) {
				if (vitamin.getSymptoms() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("type", additionalAssertFieldName)) {
				if (vitamin.getType() == null) {
					valid = false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		Assert.assertTrue(valid);
	}

	protected void assertValid(Page<Vitamin> page) {
		boolean valid = false;

		java.util.Collection<Vitamin> vitamins = page.getItems();

		int size = vitamins.size();

		if ((page.getLastPage() > 0) && (page.getPage() > 0) &&
			(page.getPageSize() > 0) && (page.getTotalCount() > 0) &&
			(size > 0)) {

			valid = true;
		}

		Assert.assertTrue(valid);
	}

	protected String[] getAdditionalAssertFieldNames() {
		return new String[0];
	}

	protected List<GraphQLField> getGraphQLFields() throws Exception {
		List<GraphQLField> graphQLFields = new ArrayList<>();

		for (Field field :
				ReflectionUtil.getDeclaredFields(
					com.denbinger.headless.vitamins.dto.v1_0.Vitamin.class)) {

			if (!ArrayUtil.contains(
					getAdditionalAssertFieldNames(), field.getName())) {

				continue;
			}

			graphQLFields.addAll(getGraphQLFields(field));
		}

		return graphQLFields;
	}

	protected List<GraphQLField> getGraphQLFields(Field... fields)
		throws Exception {

		List<GraphQLField> graphQLFields = new ArrayList<>();

		for (Field field : fields) {
			com.liferay.portal.vulcan.graphql.annotation.GraphQLField
				vulcanGraphQLField = field.getAnnotation(
					com.liferay.portal.vulcan.graphql.annotation.GraphQLField.
						class);

			if (vulcanGraphQLField != null) {
				Class<?> clazz = field.getType();

				if (clazz.isArray()) {
					clazz = clazz.getComponentType();
				}

				List<GraphQLField> childrenGraphQLFields = getGraphQLFields(
					ReflectionUtil.getDeclaredFields(clazz));

				graphQLFields.add(
					new GraphQLField(field.getName(), childrenGraphQLFields));
			}
		}

		return graphQLFields;
	}

	protected String[] getIgnoredEntityFieldNames() {
		return new String[0];
	}

	protected boolean equals(Vitamin vitamin1, Vitamin vitamin2) {
		if (vitamin1 == vitamin2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("articleId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						vitamin1.getArticleId(), vitamin2.getArticleId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("attributes", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						vitamin1.getAttributes(), vitamin2.getAttributes())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("chemicalNames", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						vitamin1.getChemicalNames(),
						vitamin2.getChemicalNames())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("creator", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						vitamin1.getCreator(), vitamin2.getCreator())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("description", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						vitamin1.getDescription(), vitamin2.getDescription())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("group", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						vitamin1.getGroup(), vitamin2.getGroup())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("id", additionalAssertFieldName)) {
				if (!Objects.deepEquals(vitamin1.getId(), vitamin2.getId())) {
					return false;
				}

				continue;
			}

			if (Objects.equals("name", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						vitamin1.getName(), vitamin2.getName())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("properties", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						vitamin1.getProperties(), vitamin2.getProperties())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("risks", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						vitamin1.getRisks(), vitamin2.getRisks())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("symptoms", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						vitamin1.getSymptoms(), vitamin2.getSymptoms())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("type", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						vitamin1.getType(), vitamin2.getType())) {

					return false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		return true;
	}

	protected boolean equals(
		Map<String, Object> map1, Map<String, Object> map2) {

		if (Objects.equals(map1.keySet(), map2.keySet())) {
			for (Map.Entry<String, Object> entry : map1.entrySet()) {
				if (entry.getValue() instanceof Map) {
					if (!equals(
							(Map)entry.getValue(),
							(Map)map2.get(entry.getKey()))) {

						return false;
					}
				}
				else if (!Objects.deepEquals(
							entry.getValue(), map2.get(entry.getKey()))) {

					return false;
				}
			}

			return true;
		}

		return false;
	}

	protected java.util.Collection<EntityField> getEntityFields()
		throws Exception {

		if (!(_vitaminResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_vitaminResource;

		EntityModel entityModel = entityModelResource.getEntityModel(
			new MultivaluedHashMap());

		Map<String, EntityField> entityFieldsMap =
			entityModel.getEntityFieldsMap();

		return entityFieldsMap.values();
	}

	protected List<EntityField> getEntityFields(EntityField.Type type)
		throws Exception {

		java.util.Collection<EntityField> entityFields = getEntityFields();

		Stream<EntityField> stream = entityFields.stream();

		return stream.filter(
			entityField ->
				Objects.equals(entityField.getType(), type) &&
				!ArrayUtil.contains(
					getIgnoredEntityFieldNames(), entityField.getName())
		).collect(
			Collectors.toList()
		);
	}

	protected String getFilterString(
		EntityField entityField, String operator, Vitamin vitamin) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		if (entityFieldName.equals("articleId")) {
			sb.append("'");
			sb.append(String.valueOf(vitamin.getArticleId()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("attributes")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("chemicalNames")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("creator")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("description")) {
			sb.append("'");
			sb.append(String.valueOf(vitamin.getDescription()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("group")) {
			sb.append("'");
			sb.append(String.valueOf(vitamin.getGroup()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("id")) {
			sb.append("'");
			sb.append(String.valueOf(vitamin.getId()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("name")) {
			sb.append("'");
			sb.append(String.valueOf(vitamin.getName()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("properties")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("risks")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("symptoms")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("type")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		throw new IllegalArgumentException(
			"Invalid entity field " + entityFieldName);
	}

	protected String invoke(String query) throws Exception {
		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.body(
			JSONUtil.put(
				"query", query
			).toString(),
			"application/json");
		httpInvoker.httpMethod(HttpInvoker.HttpMethod.POST);
		httpInvoker.path("http://localhost:8080/o/graphql");
		httpInvoker.userNameAndPassword("test@liferay.com:test");

		HttpInvoker.HttpResponse httpResponse = httpInvoker.invoke();

		return httpResponse.getContent();
	}

	protected JSONObject invokeGraphQLMutation(GraphQLField graphQLField)
		throws Exception {

		GraphQLField mutationGraphQLField = new GraphQLField(
			"mutation", graphQLField);

		return JSONFactoryUtil.createJSONObject(
			invoke(mutationGraphQLField.toString()));
	}

	protected JSONObject invokeGraphQLQuery(GraphQLField graphQLField)
		throws Exception {

		GraphQLField queryGraphQLField = new GraphQLField(
			"query", graphQLField);

		return JSONFactoryUtil.createJSONObject(
			invoke(queryGraphQLField.toString()));
	}

	protected Vitamin randomVitamin() throws Exception {
		return new Vitamin() {
			{
				articleId = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				description = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				group = StringUtil.toLowerCase(RandomTestUtil.randomString());
				id = StringUtil.toLowerCase(RandomTestUtil.randomString());
				name = StringUtil.toLowerCase(RandomTestUtil.randomString());
			}
		};
	}

	protected Vitamin randomIrrelevantVitamin() throws Exception {
		Vitamin randomIrrelevantVitamin = randomVitamin();

		return randomIrrelevantVitamin;
	}

	protected Vitamin randomPatchVitamin() throws Exception {
		return randomVitamin();
	}

	protected VitaminResource vitaminResource;
	protected Group irrelevantGroup;
	protected Company testCompany;
	protected Group testGroup;

	protected class GraphQLField {

		public GraphQLField(String key, GraphQLField... graphQLFields) {
			this(key, new HashMap<>(), graphQLFields);
		}

		public GraphQLField(String key, List<GraphQLField> graphQLFields) {
			this(key, new HashMap<>(), graphQLFields);
		}

		public GraphQLField(
			String key, Map<String, Object> parameterMap,
			GraphQLField... graphQLFields) {

			_key = key;
			_parameterMap = parameterMap;
			_graphQLFields = Arrays.asList(graphQLFields);
		}

		public GraphQLField(
			String key, Map<String, Object> parameterMap,
			List<GraphQLField> graphQLFields) {

			_key = key;
			_parameterMap = parameterMap;
			_graphQLFields = graphQLFields;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder(_key);

			if (!_parameterMap.isEmpty()) {
				sb.append("(");

				for (Map.Entry<String, Object> entry :
						_parameterMap.entrySet()) {

					sb.append(entry.getKey());
					sb.append(": ");
					sb.append(entry.getValue());
					sb.append(", ");
				}

				sb.setLength(sb.length() - 2);

				sb.append(")");
			}

			if (!_graphQLFields.isEmpty()) {
				sb.append("{");

				for (GraphQLField graphQLField : _graphQLFields) {
					sb.append(graphQLField.toString());
					sb.append(", ");
				}

				sb.setLength(sb.length() - 2);

				sb.append("}");
			}

			return sb.toString();
		}

		private final List<GraphQLField> _graphQLFields;
		private final String _key;
		private final Map<String, Object> _parameterMap;

	}

	private static final Log _log = LogFactoryUtil.getLog(
		BaseVitaminResourceTestCase.class);

	private static BeanUtilsBean _beanUtilsBean = new BeanUtilsBean() {

		@Override
		public void copyProperty(Object bean, String name, Object value)
			throws IllegalAccessException, InvocationTargetException {

			if (value != null) {
				super.copyProperty(bean, name, value);
			}
		}

	};
	private static DateFormat _dateFormat;

	@Inject
	private com.denbinger.headless.vitamins.resource.v1_0.VitaminResource
		_vitaminResource;

}