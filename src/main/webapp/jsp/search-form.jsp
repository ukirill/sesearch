<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Questions</title>
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <script src="../js/jquery-3.3.1.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
    <div class="container">
        <h1 class="display-4">Search on Stack Overflow</h1>
        <br>
        <form action="/se" method="get" id="searchForm" role="form">
            <div class="form-row">
                <div class="col-10">
                    <input type="text" name="searchString" id="searchString" class="form-control" required="true"
                           placeholder="" value="${searchString}"/>
                </div>
                <button type="submit" class="btn btn-info col-2">
                    &#x1F50D Search
                </button>
                <input type="hidden" name="sortfield" id="sortfield" value="${sortfield}"/>
            </div>
        </form>

        <div id="content-box">
            <c:choose>
                <c:when test="${not empty questionList}">
                    <table  class="table" id="results-table">
                        <thead>
                        <tr>
                            <td>Title</td>
                            <td>Author</td>
                            <td onclick="applySort('creation')" style="cursor: pointer">Date</td>
                            <td>Answers</td>
                            <td onclick="applySort('votes')" style="cursor: pointer">Score</td>
                            <td>Views</td>
                        </tr>
                        </thead>
                        <tbody id="response-table-body">
                            <jsp:include page="search-result.jsp"></jsp:include>
                        </tbody>
                    </table>
                </c:when>
                <c:otherwise>
                    <br>  </br>
                    <div class="alert alert-info">
                        No questions found matching your search criteria
                    </div>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</body>

</html>

<script type="text/javascript">
    $(document).ready(function() {
        var pagenum = 1;
        var pagesize = 30;
        var hasmore = $(".hasmore").last().val();
        $contentLoadTriggered = false;
        $(window).scroll(function(){
            if($(window).scrollTop() > $(document).height() - window.innerHeight - 30 && !$contentLoadTriggered && hasmore !== "false")
            {
                debugger;
                $contentLoadTriggered = true;
                postData = {
                    "pagenum": ++pagenum,
                    "pagesize": pagesize,
                    "searchString": "${searchString}",
                    "sortfield": "${sortfield}"
                }
                $.post("/se", postData, function(data){
                    $("#response-table-body").append(data);
                    $contentLoadTriggered = false;
                });
            }
        });
    });

    function applySort(sort) {
        $("#sortfield").val(sort);
        $("#searchString").val("${searchString}");
        $("#searchForm").submit();
    }

</script>
