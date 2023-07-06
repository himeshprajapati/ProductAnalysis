<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Excedy</title>
    <style>
        /* CSS styles */
        /* ... your existing CSS styles ... */
    </style>
    <script>
        function deleteData(id) {
            // Confirm the deletion
            if (confirm("Are you sure you want to delete this data?")) {
                // Create a form dynamically
                var form = document.createElement("form");
                form.setAttribute("method", "post");
                form.setAttribute("action", "deleteDataServlet");

                // Create an input field for the data ID
                var idInput = document.createElement("input");
                idInput.setAttribute("type", "hidden");
                idInput.setAttribute("name", "id");
                idInput.setAttribute("value", id);

                // Append the input field to the form
                form.appendChild(idInput);

                // Append the form to the document and submit it
                document.body.appendChild(form);
                form.submit();
            }
        }
    </script>
</head>
<body>
    <!-- Display the list of data -->
    <ul>
        <li>
            Data 1
            <button onclick="deleteData(1)">Delete</button>
        </li>
        <li>
            Data 2
            <button onclick="deleteData(2)">Delete</button>
        </li>
        <!-- Add more list items as needed -->
    </ul>
</body>
</html>
