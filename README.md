# HRC Summer Internship — HighRadius Corporation

A full-stack **B2B Invoice Management Web Application** built during an internship at **HighRadius Corporation**, featuring a receivables dashboard, ML-powered payment prediction, and real-time invoice operations.

[![Python](https://img.shields.io/badge/Python-3.x-1f425f?style=flat-square&logo=python&logoColor=white)](#)
[![React](https://img.shields.io/badge/React-18-20232a?style=flat-square&logo=react&logoColor=61DAFB)](#)
[![Flask](https://img.shields.io/badge/Flask-ML_Server-000000?style=flat-square&logo=flask)](#)
[![Redux](https://img.shields.io/badge/Redux-Toolkit-593d88?style=flat-square&logo=redux&logoColor=white)](#)
[![MIT License](https://img.shields.io/badge/License-MIT-green?style=flat-square)](LICENSE)

---

## Problem Statement

In B2B commerce, seller businesses issue invoices to buyer businesses operating on credit. Tracking whether invoices are paid on time — or predicting when they will be — is a critical accounts receivable challenge. This application solves that by providing a unified dashboard to manage, visualize, and predict invoice payment timelines.

---

## Tech Stack

### Backend
- **MySQL** — Relational database for invoice data
- **Java + JDBC + Servlets** — API layer and database connectivity
- **Tomcat 10** — Servlet server
- **Python 3 + Flask** — Server for the ML prediction model

### Frontend
- **React 18** — Component-based UI
- **Redux Toolkit + Redux Thunk** — State management
- **Axios** — API communication
- **Tailwind CSS** — Styling
- **Highcharts** — Data visualization (graphs)
- **Material UI** — UI component library

### ML Pipeline
- Models evaluated: **Linear Regression, SVM, Decision Tree, Random Forest, AdaBoost, XGBoost**
- Techniques: Data preprocessing, EDA, feature engineering, hyperparameter tuning (Grid Search)
- Metric: RMSE, R², MSE for regression evaluation

---

## Application Objectives

**Web Application**
- Responsive Receivables Dashboard with grid and graph data visualization
- Search, Add, Edit, and Delete invoice records
- Full-stack integration: ReactJS ↔ Java Servlets ↔ MySQL

**Machine Learning**
- View invoice data across multiple buyers
- Perform data preprocessing and exploratory data analysis
- Predict the expected payment date for each invoice

---

## Learning Outcomes

**Machine Learning** — End-to-end pipeline from raw data import through preprocessing, multi-model evaluation, and hyperparameter tuning to final model selection.

**Java** — Core Java fundamentals, OOP, SQL, JDBC for database connectivity, Servlets for request handling, Java EE for web development.

**React JS** — Component architecture, JSX, props, state, hooks (`useState`, `useEffect`, `useContext`, `useReducer`), form handling, event management, and integration with Material UI, Highcharts, and Axios + Flask backend.

---

## Project Structure

| Path | Description |
| :--- | :--- |
| [`client/src/`](client/src/) | React frontend source |
| [`server/src/main/java/crud/`](server/src/main/java/crud/) | Java Servlet backend |
| [`ml/*.ipynb`](ml/) | Jupyter Notebook — ML prediction model |
| [`ml/dataset.csv`](ml/dataset.csv) | Raw invoice dataset |
| [`database/*.sql`](database/) | MySQL schema and setup |

---

## Author

<div align="center">
  <p>Built and maintained by <a href="https://github.com/anusthan12">Anusthan Singh</a> · © 2025</p>
</div>
