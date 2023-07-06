<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Excedy </title>
    <style>
        /* CSS styles */
        /* ... your existing CSS styles ... */
        .form-container {
            max-width: 400px;
            margin: 0 auto;
            padding: 20px;
            background-color: #f2f2f2;
            border-radius: 5px;
        }
        
        .form-container h2 {
            text-align: center;
        }
        
        .form-container input,
        .form-container textarea {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }
        
        .form-container button {
            width: 100%;
            padding: 10px;
            background-color: #333;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        
        .error {
            color: red;
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h2>Add Product</h2>
        <form id="productForm" action="addProduct" method="post">
        
            <label for="productName">Product Name:</label>
            <input type="text" id="productName" name="productName" required>
            
            <label for="functionality">Functionality:</label>
            <textarea id="functionality" name="functionality" rows="4" required></textarea>
            
            <label for="performance">Performance:</label>
            <textarea id="performance" name="performance" rows="4" required></textarea>
            
            <label for="usability">Usability:</label>
            <textarea id="usability" name="usability" rows="4" required></textarea>
            
            <label for="cost">Cost:</label>
            <input type="text" id="cost" name="cost" required>
            
            <label for="value">Value:</label>
            <textarea id="value" name="value" rows="4" required></textarea>
            
            <label for="environmentalImpact">Environmental Impact:</label>
            <textarea id="environmentalImpact" name="environmentalImpact" rows="4" required></textarea>
            
            <p id="formError" class="error"></p>
            
            <button type="submit">Add</button>
        </form>
    </div>
    
    <script>
        document.getElementById('productForm').addEventListener('submit', function(event) {
            event.preventDefault();

            // Validate the form inputs
            const productName = document.getElementById('productName').value;
            const functionality = document.getElementById('functionality').value;
            const performance = document.getElementById('performance').value;
            const usability = document.getElementById('usability').value;
            const cost = document.getElementById('cost').value;
            const value = document.getElementById('value').value;
            const environmentalImpact = document.getElementById('environmentalImpact').value;

            if (!productName || !functionality || !performance || !usability || !cost || !value || !environmentalImpact) {
                document.getElementById('formError').textContent = 'Please fill in all fields.';
                return;
            }

            // If all fields are filled, submit the form
            this.submit();
        });
    </script>
</body>
</html>
