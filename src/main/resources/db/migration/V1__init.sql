CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
CREATE TABLE LEVELS
(
    id      uuid default gen_random_uuid() PRIMARY KEY,
    name    VARCHAR(55) NOT NULL,
    guesses uuid[]
);

CREATE TABLE GUESSES
(
    id        uuid default gen_random_uuid() PRIMARY KEY,
    latitude  DECIMAL,
    longitude DECIMAL
);
