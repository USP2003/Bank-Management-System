import pandas as pd
import oracledb

connection= oracledb.connect(
    user="username",
    password="password",
    dsn="localhost:1521/xe"
)
df=pd.read_sql("SELECT * FROM TRANSACTIONS", connection)
print(df)
# -----Category-wise spending----
print(df.groupby("CATEGORY")["AMOUNT"].sum())

# ------Highest transaction--------
print(df["AMOUNT"].max())

# -------Highest Risk---------
print(df[df["RISK_FLAG"]=="HIGH"])

# ------Monthly Trend---------
df["TXN_DATE"]=pd.to_datetime(df["TXN_DATE"])
print(df.groupby(df["TXN_DATE"].dt.month)["AMOUNT"].sum())

# ------HIGHEST EXPENSE CATEGORY---------
print(
    df.groupby("CATEGORY")["AMOUNT"].sum()
    .sort_values(ascending=False)
)

# ------Basic Report Generation-------
total=df["AMOUNT"].sum()
avg=df["AMOUNT"].mean()

print("Total SPending:",total)
print("Average Spending:",avg)
