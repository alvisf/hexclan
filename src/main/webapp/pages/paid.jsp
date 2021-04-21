<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Paid: ${amt}</h1>

<form action="verify" method="POST">
<script
    src="https://checkout.razorpay.com/v1/checkout.js"
    data-key="rzp_test_uwFPahVNP7SemQ" 
    data-amount="${amt}" 
    data-currency="INR"
    data-order_id="${order_id}"
    data-buttontext="Pay with Razorpay"
    data-name="Acme Corp"
    data-description="A Wild Sheep Chase is the third novel by Japanese author Haruki Murakami"
    data-image="https://example.com/your_logo.jpg"
    data-prefill.name="Gaurav Kumar"
    data-prefill.email="gaurav.kumar@example.com"
    data-theme.color="#F37254"
    
    
></script>
<input type="hidden" custom="Hidden Element" name="hidden">
</form>



</body>
</html>