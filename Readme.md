
<div dir="rtl">
بسمه تعالی
<h1>
راهنمای ایجاد headless api  در سیستم لایفری
</h1>
هدف از این راهنما، ایجاد یک headless api  در سیستم لایفری می باشد. 
</br>
بنابراین از توضیحات اضافی در مورد مفاهیمی مانند Rest, API, ... اجتناب می شود.

</br>
توجه شود که در مراحلی که از طریق blade  دستوری اجرا می شود، برای هماهنگی شدن intellij  بایستی یک بار پروژه از طریق منوی زیر دوباره refresh شود.
</div>

```
Gradle -> Reload All Gradle Projects
```
<div dir="rtl">
منوی Gradle در سمت راست صفحه قرار دارد.
</br>
</br>
<h2>
ایجاد workspace
</h2>
</br>
یک workspace با مشخصات زیر ایجاد می کنیم.
</div>

```
workspace name : vitamins
liferay version: portal-7.3-ga8
```
<div dir="rtl">
برای ایجاد workspace می توانیم از دو روش استفاده کنیم.
<h3>
</br>
روش اول: استفاده از blade
</h3>
دستور زیر را در ترمینال اجرا کنید.
</div>

``` bash
blade init -v portal-7.3-ga8 vitamins
```
<div dir="rtl">
 <h3>
 روش دوم: با استفاده از intellij (توصیه می شود.)
 </h3>
</br>
در این روش ار طریق منوی زیر یک workspace با مشخصات ذکر شده ایجاد می کنیم.
</br>
</br>
</div>

```
File -> New -> Project -> Liferay -> Liferay Gradle Workspace
```
<div dir="rtl">

در این مرجله باید initBundle  انجام شود.
</br>
</br>
<h2>
ساخت ماژول headess-vitamins
</h2>
</br>
یک ماژول با مشخصات زیر بسازید.
</div>

```
Package name: com.denbinger.vitamins
Template: rest-builder
Module name: headless-vitamins
```
<div dir="rtl">
</br>
همانند مرحله ی قبل، دو روش برای ایجاد ماژول داریم.

<h3>
روش اول: blade
</h3>
</br>
</div>

``` bash
cd  modules
blade create -t rest-builder -p com.denbinger.vitamins headless-vitamins
```
<div dir="rtl">
<h3>
روش دوم: با استفاده از intellij (توصیه می شود.)
</h3>
</br>
از طریق منوی زیر ماژول مورد نظر را بسازید.
توجه کنید که قالب rest-builder را انتخاب کنید.
</br>
</br>
</div>

```
File -> New -> Liferay Module
```

<div dir="rtl">
همان طور که مشاهده می کنید، داخل ماژول headless-vitamins چهار زیر ماژول api, client, impl, test  ایجاد شده است.
</br>
 برای پیاده سازی endpint  ها فقط کافیست فایل rest-openapi.yaml  را مطایق استاندارد OpenAPI
</div>