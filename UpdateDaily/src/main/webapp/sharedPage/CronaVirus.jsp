<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<div class="container-fluid">

 <div class="table-responsive">

  <table id="productList"  class="table table-striped table-border">
				  		
				  				<thead>
				  					<tr>

			  
            <th>State</th>
            <th>Country</th>
            <th>Last Updated</th>
            <th>Confirmed</th>
       
       	<th>Death</th>
       		<th>Recovered</th>


			</tr>
				  				
				  				</thead>
				  				<tbody>
				  				<c:forEach var="list" items="${cronaStatus}">	
				  					<tr>
				  						<td>${list.state}</td>
						          <td>${list.country}</td>
						         <td>${list.lastUpdate}</td>
						          <td>${list.confirmed}</td>
						           <td>${list.death}</td>
						            <td>${list.recovered}</td>
				  					
				  					</tr>
				  				</c:forEach>
				  				
				  				</tbody>
				  				
				  				
				  			
				  		
				  		
				  		</table>
				  		</div>
				  
</div>


