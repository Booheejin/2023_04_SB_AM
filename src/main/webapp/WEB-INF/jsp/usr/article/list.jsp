<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>        
<c:set var="pageTitle" value="${board.name } 게시판" />
<%@ include file="../common/head.jsp" %>
	<section class="mt-8 text-xl">
		<div class="container mx-auto px-3">
			<div class="mb-2 flex justify-between items-end">
					<div><span>총 : ${articlesCnt } 개</span></div>
					<c:if test="${rq.getLoginedMemberId() != 0  }">
						<a class="btn-text-link btn btn-active btn-ghost" href="write">WRITE</a>
					</c:if>
				</div>
			<div class="table-box-type-1">
				<table class="table table-zebra w-full">
					<thead>
						<tr>
							<th>번호</th>
							<th>날짜</th>
							<th>제목</th>
							<th>작성자</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="article" items="${articles }">
							<tr>
								<td>${article.id }</td>
								<td>${article.regDate }</td>
								<td><a class="btn-text-link"  href="detail?id=${article.id }">${article.title }</a></td>
								<td>${article.writerName }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</section>
<%@ include file="../common/foot.jsp" %>