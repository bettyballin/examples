import React from 'react';
import { Route, Redirect } from 'react-router-dom';
import { connect } from 'react-redux';

// Private route HOC
export const PrivateRouteComponent = ({ component: Component, state: state, ...rest }) => {
    const renderComponent = (props) => {
        if (state.login.isLoggedIn) {
            return <Component {...props} />;
        } else {
            return <Redirect to='/login' />;
        }
    };

    return (
      <Route
        {...rest}
        render={renderComponent}
      />
    );
  };

// REF: pluralsight connect container
function mapStateToProps(state, ownProps) {
    return {
        state: {
            login: state.authenticate
        }
    };
}

export const PrivateRoute = connect(mapStateToProps)(PrivateRouteComponent);