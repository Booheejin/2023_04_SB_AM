<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>        
<c:set var="pageTitle" value="login" />
<%@ include file="../common/head.jsp" %>
	<section class="mt-8 text-xl">
		<div class="container mx-auto px-3">
			<form action="dologin" method="post">
				<div class="table-box-type-1">
					<table class="table table-zebra w-full">
						<colgroup>
							<col width="200" />
						</colgroup>
						<tbody>
							<tr>
								<th>로그인 아이디</th>
								<td><input class="w-96" type="text" name="loginId" placeholder="아이디를 입력해주세요."/></td>
							</tr>
							<tr>
								<th>로그인 비밀번호</th>
								<td><input class="w-96" type="text" name="loginPw" placeholder="비밀번호를 입력해주세요."/></td>
							</tr>
							<tr>
								<td colspan="2"><button class="btn-text-link btn btn-active btn-ghost" >로그인</button></td>
								
							</tr>
							
						</tbody>
					</table>
				</div>
			</form>
			<div class="btns" >
			<button  class="btn-text-link btn btn-active btn-ghost"  type="button" onclick="history.back();">뒤로가기</button>
					
			</div>
		</div>
	</section>
<%@ include file="../common/foot.jsp" %>