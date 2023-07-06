<%@page language="java" import="java.util.*"
	import="com.db.FetchProducts" import="com.db.ProductModal"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Excedy</title>
<style>
/* CSS styles */
body {
	font-family: Arial, sans-serif;
	background-color: #f2f2f2;
	margin: 0;
	padding: 0;
}

.header {
	background-color: #333;
	color: #fff;
	padding: 20px;
	text-align: center;
}

h1 {
	margin: 0;
	font-size: 32px;
}

.hero-image {
	background-image: url('electric_car.jpg');
	background-size: cover;
	background-position: center;
	height: 200px;
}

.hero-content {
	text-align: center;
	padding: 80px;
	color: #fff;
}

.hero-content h2 {
	font-size: 36px;
	margin-bottom: 20px;
}

.hero-content p {
	font-size: 18px;
}

.features-container {
	max-width: 1200px;
	margin: 0 auto;
	padding: 40px;
}

.feature {
	display: flex;
	align-items: center;
	margin-bottom: 40px;
}

.feature img {
	width: 150px;
	margin-right: 20px;
}

.feature-content {
	flex: 1;
}

.feature h3 {
	font-size: 24px;
	margin-bottom: 10px;
}

.feature p {
	font-size: 16px;
}

.contact-container {
	background-color: #fff;
	text-align: center;
	padding: 40px;
}

.contact-form input, .contact-form textarea {
	width: 100%;
	padding: 10px;
	margin-bottom: 20px;
	border-radius: 5px;
	border: 1px solid #ccc;
}

.contact-form button {
	padding: 10px 20px;
	background-color: #333;
	color: #fff;
	border: none;
	border-radius: 5px;
	cursor: pointer;
}

.action-buttons {
	margin-top: 20px;
	display: flex;
	justify-content: center;
}

.action-buttons button {
	margin: 0 10px;
	padding: 10px 20px;
	background-color: #333;
	color: #fff;
	border: none;
	border-radius: 5px;
	cursor: pointer;
}

.product-list-container {
	background-color: #fff;
	text-align: start;
	padding-left: 100px;
}

.post-list {
	list-style-type: none;
	padding: 0;
}

.post-item {
	margin-bottom: 20px;
	padding: 10px;
	background-color: #f2f2f2;
	border-radius: 5px;
}

.post-title {
	font-size: 18px;
	font-weight: bold;
}

.post-content {
	margin-top: 10px;
	font-size: 14px;
}
</style>

</head>
<body>

	<div class="header">
		<h1>Product Details</h1>
	</div>
	<div class="hero-image">

		<div class="contact-container">

			<input type="text" name="name" placeholder="Search Products" required>
			<button>Search</button>

			<div class="action-buttons">
				<button onclick="window.location.href='AddProducts.jsp'">Add
					Product</button>

			</div>
		</div>
	</div>

	<div class=product-list-container>
		<h2>Item List</h2>
		<ul class="post-list">
			<%-- Access the list of items using JSP expression language and iterate over it --%>
			<%
			List<ProductModal> itemList = FetchProducts.getProductsList(); // Retrieve the list from the Java class
			for (ProductModal item : itemList) {
			%>
			<li class="post-item">
				<h3 class="post-title"><%=item.getProductName()%></h3>
				<p class="post-content"><%=item.getFunctionality()%></p>
				<p class="post-content"><%=item.getPerformance()%></p>
				<p class="post-content"><%=item.getUsability()%></p>
				<p class="post-content"><%=item.getCost()%></p>
				<p class="post-content"><%=item.getValue()%></p>
				<p class="post-content"><%=item.getEnvironmentalImpact()%></p>

				<form action="updateProduct" method="get">
					<input type="hidden" name="prodId" value="<%=item.getId()%>" />
					<button type="submit">
						Edit</a>
				</form>
				<form action="deleteProduct" method="get">
					<input type="hidden" name="prodId" value="<%=item.getId()%>" />
					<button type="submit">
						Delete</a>
				</form>
				<form action="productPDF" method="get">
					<input type="hidden" name="prodId" value="<%=item.getId()%>" />
					<button type="submit">
						Download</a>
				</form>
			</li>
			<%
			}
			%>
			
			
		</ul>
	</div>
	<div class="contact-container">
		<h2>Contact Us</h2>
		<form class="contact-form" action="Contact" method="post">
			<input type="text" name="name" placeholder="Your Name" required><br>
			<input type="email" name="email" placeholder="Your Email" required><br>
			<textarea name="message" placeholder="Your Message" rows="4" required></textarea>
			<br>
			<button type="submit">Send Message</button>


			<button onclick="printPage()">Print</button>
			<script>
				document.getElementById('updateButton').addEventListener(
						'click', function(event) {
							event.preventDefault();

						});

				document.getElementById('deleteButton').addEventListener(
						'click', function(event) {
							event.preventDefault();

						});

				function printPage() {
					window.print();
				}
			</script>
		</form>

	</div>

</body>
</html>
