import PropTypes from "prop-types";
import "./button.scss";

function Button({ className = "", onClick = null, children }) {
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

export default Button;

export function OutlineButton({ className = "", onClick = null, children }) {
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
