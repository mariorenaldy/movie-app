import PropTypes from "prop-types";
import "./button.scss";

function Button({ className, onClick, children }) {
  return (
    <button className={`btn ${className}`} onClick={onClick ? () => onClick() : null}>
      {children}
    </button>
  );
}

Button.propTypes = {
  className: PropTypes.string,
  onClick: PropTypes.func,
  children: PropTypes.node.isRequired,
};

Button.defaultProps = {
  className: "",
  onClick: null,
};

export function OutlineButton({ className, onClick, children }) {
  return (
    <Button className={`btn-outline ${className}`} onClick={onClick ? () => onClick() : null}>
      {children}
    </Button>
  );
}

OutlineButton.propTypes = {
  className: PropTypes.string,
  onClick: PropTypes.func,
  children: PropTypes.node.isRequired,
};

OutlineButton.defaultProps = {
  className: "",
  onClick: null,
};

export default Button;
