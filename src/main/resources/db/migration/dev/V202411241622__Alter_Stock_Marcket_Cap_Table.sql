-- 1. ticker 컬럼 추가
ALTER TABLE stock_market_cap
    ADD COLUMN ticker VARCHAR(50);

-- 2. 외래 키 제약 조건 추가
ALTER TABLE stock_market_cap
    ADD CONSTRAINT FOREIGN KEY (ticker) REFERENCES stock(stockcode);

-- 3. ticker 업데이트: stockcode가 존재할 경우에만 업데이트
UPDATE stock_market_cap sm
SET sm.ticker = (
    SELECT s.stockcode
    FROM stock s
    WHERE s.stockcode = sm.stockcode
)
WHERE EXISTS (
    SELECT 1
    FROM stock s
    WHERE s.stockcode = sm.stockcode
);