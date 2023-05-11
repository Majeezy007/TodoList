<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class = "container">
	<h1>Enter your TODO details</h1>
	<form:form method="post" class="form-group" modelAttribute="todo">
		<fieldset>
			<form:label path="description">Description:</form:label>
			<form:input type="text" path="description" required="required"/>
			<form:errors path="description" cssClass="text-danger"/><br><br>
		</fieldset>
		
		<fieldset>
			<form:label path="target">Date:</form:label>
			<form:input type="text" path="target" required="required"/>
			<form:errors path="target" cssClass="text-danger"/><br><br>
		</fieldset>
		
		<input type="submit" class="btn btn-success"/>
	</form:form>
</div>
<%@ include file="common/footer.jspf" %>
<script type="text/javascript">
	$('#target').datepicker({
	    format: 'yyyy-mm-dd'
	});
</script>