<style>
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

</style>
<form class="contact-form" action="Contact" method="post">
			<input type="text" name="name" placeholder="Your Name" required><br>
			<input type="email" name="email" placeholder="Your Email" required><br>
			<textarea name="message" placeholder="Your Message" rows="4" required></textarea>
			<br>
			<button type="submit">Send Message</button>