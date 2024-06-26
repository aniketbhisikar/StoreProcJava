CREATE DEFINER=`root`@`localhost` PROCEDURE `bank_transaction_details`( 
	IN acct_num varchar(20), 
    IN tran_amt float(10,2),
    IN cust_id varchar(50),
    IN tran_memo varchar(100),
    IN tran_type varchar(10)
)
BEGIN
	DECLARE e1 varchar(10);
	/*DECLARE e2 varchar(100);
	DECLARE e3 varchar(10);
	DECLARE e4 varchar(10);

	SET e1 = cast(cust_name as CHAR)+" did "+cast(tran_type as CHAR)+" transaction for Rs."+cast(tran_amt as CHAR);
	SET e2 = "transaction for Rs.";
	SET e3 = "credit";
	SET e1 = "did";*/
	SET e1 = "credit";

    
	IF tran_type = e1 THEN
		INSERT INTO barclays.transactions(account_number,customer_id, transaction_memo) values (acct_num, cust_id, tran_memo);
        UPDATE barclays.bank_account SET account_balance = account_balance+tran_amt WHERE account_number=acct_num;
	else
		INSERT INTO barclays.transactions(account_number,customer_id, transaction_memo) values (acct_num, cust_id, tran_memo);
        UPDATE barclays.bank_account SET account_balance = account_balance-tran_amt WHERE account_number=acct_num;
	END  if;
END