--##########Procedure stockée suppression d'image 10 jours apres non utilisation###########
create or replace procedure SuppressionImage is
BEGIN
	DELETE from Img
	where (sysdate-dateDerniereUtilisation)>=10;
END;
/

/*
call dbms_scheduler.drop_job('SuppressionImage');

create or replace function nbJours(dateUtilisation IN date)
return number 
IS
BEGIN
	return trunc(sysdate-dateUtilisation);
END;
/

create or replace procedure SuppressionImage is
BEGIN
	DELETE from Img
	where (sysdate-dateDerniereUtilisation)>=10;
END;
/

BEGIN
 DBMS_SCHEDULER.CREATE_JOB(
	job_name => 'SuppressionImage',
	job_type => 'STORED_PROCEDURE',
	job_action =>'SuppressionImage',
	start_date => SYSTIMESTAMP,
	repeat_interval => 'FREQ = DAILY',
	end_date => null,
	auto_drop => false,
	comments => 'image(s) supprimées');
END;
/
call dbms_scheduler.run_job('SuppressionImage');
*/