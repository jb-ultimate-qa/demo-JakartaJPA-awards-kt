-- Insert data into sport_school table
INSERT INTO sport_school (id, title) VALUES
     ('SS001', 'Elite Sports Academy'),
     ('SS002', 'City Sports Club'),
     ('SS003', 'National Training Center'),
     ('SS004', 'Urban Sports Institute'),
     ('SS005', 'Victory School of Sports');

-- Insert data into license table
INSERT INTO license (sn, descr, license_number) VALUES
    (101, 'National Referee License', 'LR001'),
    (102, 'International Referee License', 'LR002'),
    (103, 'Regional Referee License', 'LR003'),
    (104, 'Local Referee License', 'LR004'),
    (105, 'State Referee License', 'LR005');

-- Insert data into player table
INSERT INTO player (id, rating, first_name) VALUES
    (1, 1200, 'John'),
    (2, 1100, 'Alice'),
    (3, 1250, 'Bob'),
    (4, 1300, 'Carol'),
    (5, 1150, 'David'),
    (6, 1400, 'Eve'),
    (7, 1350, 'Frank'),
    (8, 1450, 'Grace'),
    (9, 1250, 'Hank'),
    (10, 1100, 'Ivy');

-- Insert data into referee table
INSERT INTO referee (id, license_id, first_name) VALUES
     (1, 1, 'Mike'),
     (2, 2, 'Nancy'),
     (3, 3, 'Oscar'),
     (4, 4, 'Paul'),
     (5, 5, 'Quincy');

-- Insert data into player_sport_school table
INSERT INTO player_sport_school (player_id, sport_school_id) VALUES
     (1, 'SS001'),
     (2, 'SS002'),
     (3, 'SS003'),
     (4, 'SS004'),
     (5, 'SS005'),
     (6, 'SS001'),
     (7, 'SS002'),
     (8, 'SS003'),
     (9, 'SS004'),
     (10, 'SS005');

-- Insert data into competition table
INSERT INTO competition (competition_level, first_player_id, referee_id, second_player_id, id, city, stadium, title) VALUES
    (0, 1, 1, 2, 1001, 'Paris', 'Parc des Princes', 'City Championship'),
    (1, 3, 2, 4, 1002, 'Berlin', 'Olympiastadion', 'State Finals'),
    (2, 5, 3, 6, 1003, 'Madrid', 'Santiago Bernabeu Stadium', 'Regional Tournament'),
    (3, 7, 4, 8, 1004, 'Rome', 'Stadio Olimpico', 'National League'),
    (0, 9, 5, 10, 1005, 'London', 'Wembley Stadium', 'Local Showdown');

-- Insert data into award table
INSERT INTO award (id, winner_id, year_, title) VALUES
    (1, 1, 2024, 'Best Player of the Year'),
    (2, 2, 2024, 'Top Scorer Award'),
    (3, 3, 2023, 'Most Improved Player'),
    (4, 4, 2023, 'Best Newcomer'),
    (5, 5, 2022, 'Lifetime Achievement Award'),
    (6, 6, 2024, 'Best Team Player'),
    (7, 7, 2023, 'Outstanding Performance'),
    (8, 8, 2022, 'Best Defensive Player'),
    (9, 9, 2024, 'Best Offense Award'),
    (10, 10, 2023, 'Most Valuable Player');