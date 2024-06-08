DELIMITER $$  
CREATE PROCEDURE `product.UpdateInventory` (IN ProductID INT, IN QuantityChange INT)
BEGIN
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
	BEGIN TRANSACTION
		-- Check if the product exists
		IF NOT EXISTS(SELECT 1 FROM `Products` WHERE ProductID = ProductID)
			/*THROW 50000, 'Product does not exist.', 1;*/

		-- Update inventory
		UPDATE Products
		SET Quantity = Quantity + QuantityChange
		WHERE ProductID = ProductID;

		-- Log the inventory change
		INSERT INTO InventoryLog(ProductID, QuantityChange, ChangeDate)
		VALUES (ProductID, QuantityChange, GETDATE());

	COMMIT TRANSACTION
    END
END $$
DELIMITER $$ 