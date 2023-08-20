<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="pageTitle" value="<span><i class='far fa-clipboard'></i></span> <span>${board.name} ARTICLE LIST</span>" />
<c:set var="titleName" value="게시물 리스트" />
<%@ include file="../common/head.jspf"%>

<div class="section section-article-list">
  <div class="container mx-auto">

    <div class="total-items">
      <span>TOTAL ITEMS :</span>
      <span>${totalItemsCount}</span>
    </div>

    <div class="total-pages">
      <span>TOTAL PAGES :</span>
      <span>${totalPage}</span>
    </div>

    <div class="page">
      <span>CURRENT PAGE :</span>
      <span>${page}</span>
    </div>

  </div>
</div>

<hr />
<hr />

<div class="articles">
  <c:forEach items ="${articles }" var = "article">
    <table  class = "border w-full" >
      <tbody>
        <tr>
          <th >번호<th>
          </td>${article.id }</td>
        </tr>
        <tr>
          <th>작성날짜<th>
          </td>${article.regDate }</td>
        </tr>
        <tr>
          <th>수정날짜<th>
          </td>${article.updateDate }</td>
        </tr>
        <tr>
          <th>작성자<th>
          </td>${article.memberId }</td>
        </tr>
        <tr>
          <th>제목<th>
          </td>${article.title }</td>
        </tr>
        
      </tbody>
    </table>

  </c:forEach>
</div>

<%@ include file="../common/foot.jspf"%>