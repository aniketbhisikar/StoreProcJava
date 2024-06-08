CREATE DEFINER=`root`@`localhost` PROCEDURE `calculate_interest_on_loan`(
IN loan_amt varchar(100),
IN rate_of_interest tinyint(10),
IN tenure_in_years tinyint(3))
BEGIN
	declare interest int;
	SET interest = calculate_interest(loan_amt,rate_of_interest,tenure_in_years);
	select interest;
END