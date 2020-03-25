<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container">
<h1>Coronavirus Tracker Application</h1>
<p>This application lists the current number of cases reported across the globe</p>

<div class="jumbotron">
    <h1 class="display-4" "${totalReportedCases}></h1>
    <p class="lead">Total cases reported as of today</p>
    <hr class="my-4">
    <p>
        <span>New cases reported since previous day:</span>
        <span ${totalNewCases}></span>
    </p>

</div>

    <table class="table">
        <tr>
            <th>State</th>
            <th>Country</th>
            <th>Total cases reported</th>
            <th>Changes since last day</th>
        </tr>
        
      
     
    </table>
</div>
