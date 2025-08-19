import * as Sentry from '@sentry/react';
import React from 'react';
import ReactDOM from 'react-dom/client';
import { BrowserRouter } from 'react-router';

import App from '@app/App';

import FallBackPage from '@pages/fallBackPage/FallBackPage';

import { LocationsProvider } from '@entities/contexts/LocationsProvider';

import Layout from '@shared/components/layout/Layout';
import { ErrorBoundary } from '@shared/errors-handling/ErrorBoundary';
import GlobalStyle from '@shared/styles/GlobalStyle';

if (process.env.NODE_ENV === 'production') {
  Sentry.init({
    dsn: process.env.SENTRY_DSN,
    // Setting this option to true will send default PII data to Sentry.
    // For example, automatic IP address collection on events
    sendDefaultPii: true,
    integrations: [
      Sentry.feedbackIntegration({
        colorScheme: 'system',
      }),
    ],
  });
}

ReactDOM.createRoot(document.getElementById('root')!).render(
  <ErrorBoundary
    fallbackRender={({ reset }) => <FallBackPage reset={reset} />}
    onReset={() => window.location.reload()}
  >
    <React.StrictMode>
      <GlobalStyle />
      <LocationsProvider>
        <BrowserRouter>
          <Layout>
            <App />
          </Layout>
        </BrowserRouter>
      </LocationsProvider>
    </React.StrictMode>
  </ErrorBoundary>,
);
