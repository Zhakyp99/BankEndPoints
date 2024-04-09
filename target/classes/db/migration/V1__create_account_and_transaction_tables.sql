CREATE TABLE account (
                         id VARCHAR(255) PRIMARY KEY,
                         account_type VARCHAR(255),
                         client_id VARCHAR(255),
                         balance DOUBLE,
                         withdraw_allowed BOOLEAN
);
CREATE TABLE transaction (
                             id VARCHAR(255) PRIMARY KEY,
                             account_id VARCHAR(255),
                             transaction_details VARCHAR(255)
);