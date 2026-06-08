<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   

<%@include file="../inc/header.jsp"  %>
<!-- 	header		 -->
<!-- 	header		 -->
<script>
window.addEventListener("load", function(){
	let result = '${result}';   // el
	console.log(result);
	
	if( result == "글쓰기 실패"  || result == "삭제 실패" ){ alert(result);  history.go(-1); } // 알림창, 뒤로가기
	if(result.length != 0){ alert(result); }  
});
</script>


    <!--  content -->
    <section class="container  my-5">
        <h3> MultiBoard </h3>
        <table  class="table  table-striped  table-bordered table-hover">
            <caption> BOARD 목록 </caption>
            <thead>
                <tr>
                    <th scope="col">NO</th>
                    <th scope="col">TITLE</th>
                    <th scope="col">WRITER</th>
                    <th scope="col">DATE</th>
                    <th scope="col">HIT</th>
                </tr>
            </thead>
            <tbody>
            	<c:forEach var="dto" items="${list}" varStatus="status">
				<tr>   <!-- 전체갯수        상태갯수 -->
					<td>${paging.listtotal - paging.pstartno - status.index}</td>
					<td><a href="${pageContext.request.contextPath}/board/detail.do?bno=${dto.bno}"
						   style="text-decoration:none;">${dto.btitle} </a></td>
					<td>${dto.bname}</td>
					<td>${dto.bdate}</td>
					<td>${dto.bhit}</td>
				</tr>
				</c:forEach>
            </tbody>
            <tfoot><tr><td colspan="5">
            	<ul class="pagination  justify-content-center"> 
            	<!-- 이전 -->
            	<c:if test="${paging.start > 1}">
			        <li class="page-item">
			            <a class="page-link"
			               href="?pstartno=${paging.start-1}">
			               이전
			            </a>
			        </li>
			    </c:if>
    
            	<!-- 1,2,3,4,5,,,,10 -->
            	<c:forEach var="i" begin="${paging.start}" end="${paging.end}">
			        <li class="page-item <c:if test="${i==paging.current}">  active </c:if> ">
			        	<a href="?pstartno=${i}" class="page-link">${i}</a>
			        </li>
			    </c:forEach>
			    
            	<!-- 다음 -->
            	<c:if test="${paging.end < paging.pagetotal}">
			        <li class="page-item">
			            <a class="page-link"
			               href="?pstartno=${paging.end+1}">
			               다음
			            </a>
			        </li>
			    </c:if>
            	</ul></td></tr>
            </tfoot>
        </table>

        <div  class="text-end">
           <a href="${pageContext.request.contextPath}/board/write.do"  
           	  title="글쓰기 폼"  class="btn btn-primary" >글쓰기</a>
        </div>

    </section>

 
<!-- 	footer		 -->
<!-- 	footer		 -->
<%@include file="../inc/footer.jsp"  %>


<!--         
 http://localhost:8080/spring003_mvc/
	<tr>
                 <td>1</td>
                 <td>첫번째 글쓰기</td>
                 <td>FIRST</td>
                 <td>2026.05</td>
                 <td><span class="badge rounded-pill bg-dark">1</span></td>
             </tr> 
         -->