<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:forEach var="question" items="${questionList}">
    <c:set var="classSuccess" value=""/>
    <c:choose>
        <c:when test="${question.answerCount > 0}">
            <c:set var="classSuccess" value="table-success"/>
        </c:when>
    </c:choose>
    <tr class="${classSuccess}">
        <td>
            <a href="${question.link}">${question.title}</a>
        </td>
        <td>${question.owner.displayName}</td>
        <td>${question.creationDate}</td>
        <td>${question.answerCount} &#x1F4AC</td>
        <td>${question.score} &#x2B50</td>
        <td>${question.viewCount} &#x1F441</td>
    </tr>
</c:forEach>
<input type="hidden" class="hasmore" value="${hasmore}"/>