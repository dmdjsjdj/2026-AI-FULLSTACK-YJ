<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@include file="inc/header.jsp" %>
    <!--  jasp014_header.jsp -->
    <!--  jasp014_header.jsp -->
    <div class="container my-5">
        <h3 >글 등록 </h3>
        
        <form  action ="write_action.jsp"  method="post"   onsubmit="return checkForm()">
	         <div  class="my-3">
	            <label for="bname"   class="form-label">이름</label>
	            <input type="text"   class="form-control"    id="bname"  name="bname"  />
	         </div> 
	         <div  class="my-3">
	            <label for="bpass"   class="form-label">비밀번호</label>
	            <input type="password"   class="form-control"    id="bpass"  name="bpass"  />
	         </div>
	         <div  class="my-3">
	            <label for="btitle"  class="form-label">제목</label>
	            <input type="text"   class="form-control"    id="btitle"  name="btitle"  />
	         </div>
	         <div  class="my-3">
	            <label for="bcontent"  class="form-label">내용</label>
	            <textarea  class="form-control"    id="bcontent"  name="bcontent"  ></textarea>
	         </div>
	         <div  class="my-3  text-end"> 
	            <button type="reset"   class="btn btn-outline-primary"  title="글취소">취소</button>
	            <a href='list.jsp'     class="btn btn-outline-success"  title="목록보러가기">목록</a>
	            <button type="submit"  class="btn btn-primary"  title="글등록">글쓰기</button>
	         </div>
	      </form> 
        
        <script>
			function checkForm(){
			
			    let name = document.getElementById("bname");
			    let pass = document.getElementById("bpass");
			    let tiele = document.getElementById("btitle");
			    let con = document.getElementById("bcontent");
			
			    if(name.value.trim() == ""){ alert("빈칸입니다. \n확인해주세요."); name.focus(); return false; }
			    if(pass.value.trim() == ""){ alert("빈칸입니다. \n확인해주세요."); pass.focus(); return false; } 
			    if(tiele.value.trim() == ""){ alert("빈칸입니다. \n확인해주세요."); tiele.focus(); return false; } 
			    if(con.value.trim() == ""){ alert("빈칸입니다. \n확인해주세요."); con.focus(); return false; }
			    
			    return true;
			}
		</script>
    </div>
	<!--  jasp014_footer.jsp -->
    <!--  jasp014_footer.jsp -->
<%@include file="inc/footer.jsp" %>