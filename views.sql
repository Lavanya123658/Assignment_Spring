
drop database leavetrackingsystem;
create database leavetrackingsystem;

SELECT * FROM leavetrackingsystem.user;
SELECT * FROM leavetrackingsystem.leave;
SELECT * FROM leavetrackingsystem.settings;

SET SQL_SAFE_UPDATES = 0;
-- delete from leavetrackingsystem.settings; 

use leavetrackingsystem;
-- --------------------- FOR EMPLOYEE WISE LEAVE SUMMARY----------------------------------------

CREATE or replace VIEW leave_summary AS
SELECT
    ROW_NUMBER() OVER () AS serial_no,
    u.name,
     -- (SELECT SUM(max_leaves) FROM settings) AS total_max_leaves,
    SUM(CASE WHEN l.status = 'APPROVED' THEN 1 ELSE 0 END) AS leaves_approved,
    SUM(CASE WHEN l.status = 'PENDING' THEN 1 ELSE 0 END) AS leaves_pending,
    SUM(CASE WHEN l.status = 'REJECTED' THEN 1 ELSE 0 END) AS leaves_rejected,
    (SELECT SUM(max_leaves) FROM settings) - SUM(CASE WHEN l.status = 'APPROVED' THEN 1 ELSE 0 END) - SUM(CASE WHEN l.status = 'PENDING' THEN 1 ELSE 0 END) - SUM(CASE WHEN l.status = 'REJECTED' THEN 1 ELSE 0 END) AS leaves_remaining
FROM
    `leave` l
JOIN
    user u ON l.user_id = u.id
GROUP BY
    u.id;
    
select * from leave_summary;

-- ------------ VIEW FOR LEAVE SUMMARY FILTERED(STATIC)-----------------------------
CREATE OR REPLACE VIEW leave_summary_filtered_view AS
SELECT
    ROW_NUMBER() OVER () AS serial_no,
    u.name,
    SUM(CASE WHEN l.status = 'APPROVED' THEN 1 ELSE 0 END) AS leaves_approved,
    SUM(CASE WHEN l.status = 'PENDING' THEN 1 ELSE 0 END) AS leaves_pending,
    SUM(CASE WHEN l.status = 'REJECTED' THEN 1 ELSE 0 END) AS leaves_rejected
    -- (SELECT SUM(max_leaves) FROM settings) - 
--         SUM(CASE WHEN l.status = 'APPROVED' THEN 1 ELSE 0 END) - 
--         SUM(CASE WHEN l.status = 'PENDING' THEN 1 ELSE 0 END) - 
--         SUM(CASE WHEN l.status = 'REJECTED' THEN 1 ELSE 0 END) AS leaves_remaining
FROM
	`leave` l
JOIN
    user u ON l.user_id = u.id
WHERE
    (l.start_date BETWEEN "2024-06-30" AND "2024-07-05") and (l.end_date <= "2024-07-05")
GROUP BY
    u.id;

select * from leave_summary_filtered_view;


-- ------------------- PROCEDURE FOR LEAVE SUMMARY FILTERED -------------------

DELIMITER $$
CREATE PROCEDURE leave_summary_filtered(IN fromDate DATE, IN toDate DATE)
BEGIN
    SELECT
        ROW_NUMBER() OVER () AS serial_no,
        u.name,
        SUM(CASE WHEN l.status = 'APPROVED' THEN 1 ELSE 0 END) AS leaves_approved,
        SUM(CASE WHEN l.status = 'PENDING' THEN 1 ELSE 0 END) AS leaves_pending,
        SUM(CASE WHEN l.status = 'REJECTED' THEN 1 ELSE 0 END) AS leaves_rejected
    FROM
        `leave` l
    JOIN
        user u ON l.user_id = u.id
    WHERE
        (l.start_date BETWEEN fromDate AND toDate) AND (l.end_date <= toDate)
    GROUP BY
        u.id;
END $$
CALL leave_summary_filtered('2024-06-27', '2024-07-05');