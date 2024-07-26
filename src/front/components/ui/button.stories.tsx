import type {Meta, StoryObj} from '@storybook/react';

import {Button} from './button';

const meta = {
    component: Button,
    title: 'Components/UI/Button',
    tags: ["autodocs"],
    parameters: {
        layout: 'centered',
    },
    argTypes: {
        variant: {
            options: ['default', 'destructive', 'outline', 'link', 'ghost'],
            control: { type: 'select' }
        },
        size: {
            options: ['default', 'sm', 'lg'],
            control: { type: 'select' }
        },

    }
} satisfies Meta<typeof Button>;

export default meta;

type Story = StoryObj<typeof meta>;

export const Default: Story = {
    args: {
        variant: 'default',
        disabled: false,
        size: "default",
        children: "Default Button"
    }
};
export const Destructive: Story = {
    args: {
        variant: 'destructive',
        children: "Destructive Button"
    }
};
