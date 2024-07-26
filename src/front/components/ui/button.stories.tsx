import type {Meta, StoryObj} from '@storybook/react';

import {Button} from './button';

const meta = {
    component: Button,
    title: 'Components/UI/Button',
    tags: ["autodocs"],
    parameters: {
        layout: 'centered',
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
