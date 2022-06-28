import yfinance as yf
import os
import csv

class Stock:

    # Initialize Stock object based off of ticker
    def __init__(self, ticker: str):
        self.ticker = ticker
        return

    # If no arguments given then function will check if stock has folder and default to 1m
    # If argument for data collection frequency is given then then function will return stock file
    # Else return None
    def check_data(self, freq: str = "1m") -> str:
        path = "raw_data/" + self.ticker + "/" + freq + ".txt"

        if(not os.path.exists(path)):
            if not os.path.exists("raw_data/" + self.ticker):
                os.makedirs("raw_data/" + self.ticker)
            with open(path, 'w') as f:
                writer = csv.writer(f)
                header = ["ticker"]
                writer.writerow(header)
                header = ["price", "date", "time"]
                writer.writerow(header)
        
        return path

def main():
    stock = Stock("AAPL")

    stock.check_data()

main()
