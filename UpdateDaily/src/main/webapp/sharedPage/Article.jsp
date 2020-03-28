
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<div class="table-responsive">

  <table id="article"  class="table table-striped table-border">
				  		
				  				<thead>
				  					<tr>

			  
            <th>Article Title</th>
         
          
       
     


			</tr>
				  				
				  				</thead>
				  				<tbody>
				  			<c:forEach var="list" items="${article}">
				  				<tr>
				  					<td>${list.title}</td>
						         
						         
						         
				  				</tr>
				  				</c:forEach>
				  				</tbody>
				  				
				  				
				  			
				  		
				  		
				  		</table>
				  		</div>
				  