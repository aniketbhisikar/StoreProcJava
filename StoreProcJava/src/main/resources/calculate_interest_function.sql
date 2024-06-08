CREATE DEFINER=`root`@`localhost` FUNCTION `calculate_interest`(
loan_amt int,
rate_of_interest tinyint(10),
tenure_in_years tinyint(3)) RETURNS int
    DETERMINISTIC
BEGIN
	DECLARE interest int(11);
	SET interest = (loan_amt * tenure_in_years * rate_of_interest)/100;
RETURN interest;
END