<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Manage Invoice</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
		
		.cash { display: none; }
		.security { display: none; }
	</style>
	<script>
	
	function showOption() {
	    if (document.getElementById('cash').checked) {
	    	console.log("Cash Selected");
	        document.getElementById('cors').style.display = 'block';
	        document.getElementById('fees').style.display = 'none';
	    }
	    else {
	    	console.log("Security Selected");
	        document.getElementById('cors').style.display = 'none';
	        document.getElementById('fees').style.display = 'block';
	    }

	} 
	</script>
</head>
<body>
<h2>Add Invoice for Library Membership</h2>

<c:url var="addAction" value="/add" ></c:url>
<form:form action="${addAction}" commandName="invoice">
<table>
	<tr>
		<td>
			<form:label path="username">
				<spring:message text="Username"/>
			</form:label>
		</td>
		<td>
			<form:input path="username" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="amount">
				<spring:message text="Amount"/>
			</form:label>
		</td>
		<td>
			<form:input path="amount" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="gst">
				<spring:message text="GST"/>
			</form:label>
		</td>
		<td>
			<form:input path="gst" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="date">
				<spring:message text="Invoice Date"/>
			</form:label>
		</td>
		<td>
			<form:input path="date" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="type">
				<spring:message text="Invoice Type"/>
			</form:label>
		</td>
		<td>
			<form:radiobutton path="type" name="cash" id="cash" value="Cash" onclick="javascript:showOption();"/>Cash Invoice
			<form:radiobutton path="type" name="security" id="security" value="Security" onclick="javascript:showOption();"/>Security Invoice
		</td>
	</tr>
		<tr id=cors style="display:none;">
			<td>
				<form:label path="collectedOrSupplied">
					<spring:message text="Collected or Supplied"/>
				</form:label>
			</td>
			<td>
				<form:radiobutton path="collectedOrSupplied" value="Collected"/>Collected
				<form:radiobutton path="collectedOrSupplied" value="Supplied"/>Supplied
			</td>
		</tr>
	<tr id=fees style="display:none;">
		<td>
			<form:label path="fee">
				<spring:message text="Fee Amount"/>
			</form:label>
		</td>
		<td>
			<form:input path="fee" />
		</td>
	</tr>
	
	<tr>
		<td colspan="2">
			<c:if test="${!empty invoice.amount}">
				<input type="submit"
					value="<spring:message text="Add Invoice"/>" />
			</c:if>
			<c:if test="${empty invoice.amount}">
				<input type="submit"
					value="<spring:message text="Add Invoice"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br>
<h3>Invoice List</h3>
<c:if test="${!empty listInvoice}">
	<table class="tg">
	<tr>
		<th width="80">Invoice ID</th>
		<th width="120">Username</th>
		<th width="120">Amount</th>
		<th width="120">GST</th>
		<th width="120">Invoice Date</th>
		<th width="120">Invoice Type</th>
		<th width="120">Collected or Supplied</th>
		<th width="120">Security Fee</th>
	</tr>
	<c:forEach items="${listInvoice}" var="invoice">
		<tr>
			<td>${invoice.id}</td>
			<td>${invoice.username}</td>
			<td>${invoice.amount}</td>
			<td>${invoice.gst}</td>
			<td>${invoice.date}</td>
			<td>${invoice.type}</td>
			<c:if test="${!empty invoice.collectedOrSupplied}">
			<td>${invoice.collectedOrSupplied}</td>
			</c:if>
			<c:if test="${empty invoice.collectedOrSupplied}">
			<td>N/A</td>
			</c:if>
			<c:if test="${!empty invoice.fee}">
			<td>${invoice.fee}</td>
			</c:if>
			<c:if test="${empty invoice.fee}">
			<td>N/A</td>
			</c:if>
		</tr>
	</c:forEach>
	</table>
</c:if>
<c:if test="${empty listInvoice}">
	<table class="tg">
	<tr>
		<th width="80">Invoice ID</th>
		<th width="120">Username</th>
		<th width="120">Amount</th>
		<th width="120">GST</th>
		<th width="120">Invoice Date</th>
		<th width="120">Invoice Type</th>
		<th width="120">Collected or Supplied</th>
		<th width="120">Security Fee</th>
	</tr>
	</table>
</c:if>
</body>
</html>
