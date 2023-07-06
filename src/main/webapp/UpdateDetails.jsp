<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Excedy</title>
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
        <h2>Update Product</h2>
        <form id="productForm" action="updateProduct" method="post">
           
            <input type="hidden" name="prodId" value="${id}" />
            
            <label for="productName">Product Name:</label>
            <input type="text" id="productName" name="productName" value="${productName}" required>
            
            <label for="functionality">Functionality:</label>
            <input id="functionality" name="functionality" rows="4" value="${functionality}" required></textarea>
            
            <label for="performance">Performance:</label>
            <input id="performance" name="performance" rows="4" value="${performance}" required></textarea>
            
            <label for="usability">Usability:</label>
            <input id="usability" name="usability" rows="4" value="${usability}" required></textarea>
            
            <label for="cost">Cost:</label>
            <input type="text" id="cost" name="cost" value="${cost}" required>
            
            <label for="value">Value:</label>
            <input id="value" name="value" rows="4" value="${value}" required></textarea>
            
            <label for="environmentalImpact">Environmental Impact:</label>
            <input id="environmentalImpact" name="environmentalImpact" rows="4" value="${environmentalImpact}" required></textarea>
            
            <p id="formError" class="error"></p>
            
            <button type="submit">Update</button>
        </form>
    </div>
    
    
</body>
</html>
