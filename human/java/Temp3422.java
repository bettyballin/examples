html
<div class="form-group" style="padding-bottom: 10px;  display: flex;justify-content: left;margin-bottom:0;">
    <label style="color:white;font-size:12px;margin-right: 10px;" for="countryInput" th:text="#{modif.country}"></label>
    <select class="form-control" id="countryInput" style="width: 200px;font-size:12px;margin-bottom:0;">
        <option th:each="country :${T(fr.model.enumeration.Country).values()}" th:value="${country}" th:text="${country}"></option>
    </select>
</div>