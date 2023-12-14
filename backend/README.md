### SQL Query to reorder the percentage_calculation table (while create-drop is enabled)
```
ALTER TABLE percentage_calculation 
    MODIFY COLUMN calculation_type VARCHAR(255) NOT NULL AFTER id,
    MODIFY COLUMN value1 DECIMAL(19, 4) NOT NULL AFTER calculation_type,
    MODIFY COLUMN value2 DECIMAL(19, 4) NOT NULL AFTER value1,
    MODIFY COLUMN result DECIMAL(19, 4) NOT NULL AFTER value2;
```

### Swagger
http://localhost:8080/swagger-ui/index.html#/